begin
    for cur in (select fk.owner, fk.constraint_name , fk.table_name
                from all_constraints fk, all_constraints pk
                where fk.CONSTRAINT_TYPE = 'R' and
                        pk.owner = 'API_STUDENT_GRADUATION' and
                        fk.r_owner = pk.owner and
                        fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME and
                        fk.TABLE_NAME = 'PROGRAM_ALGORITHM_RULE') loop
            execute immediate 'ALTER TABLE "'||cur.owner||'"."'||cur.table_name||'" MODIFY CONSTRAINT "'||cur.constraint_name||'" DISABLE';
        end loop;
end;
/

UPDATE ALGORITHM_RULE_CODE SET LABEL = 'Registration Duplicate Course Rule', RULE_IMPL_NAME = 'RegistrationsDuplicateCrseRule', ALGORITHM_RULE_CODE = 'REGTN_DUPLICATE_CRSE_RULE' WHERE ALGORITHM_RULE_CODE = 'REGTN_DUPLICATE_RULE';
/
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE = 'REGTN_DUPLICATE_CRSE_RULE' WHERE ALGORITHM_RULE_CODE = 'REGTN_DUPLICATE_RULE';
/

begin
    for cur in (select fk.owner, fk.constraint_name , fk.table_name
                from all_constraints fk, all_constraints pk
                where fk.CONSTRAINT_TYPE = 'R' and
                        pk.owner = 'API_STUDENT_GRADUATION' and
                        fk.r_owner = pk.owner and
                        fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME and
                        fk.TABLE_NAME = 'PROGRAM_ALGORITHM_RULE') loop
            execute immediate 'ALTER TABLE "'||cur.owner||'"."'||cur.table_name||'" MODIFY CONSTRAINT "'||cur.constraint_name||'" ENABLE';
        end loop;
end;
/

Insert into ALGORITHM_RULE_CODE (ALGORITHM_RULE_CODE,RULE_IMPL_NAME,LABEL,DESCRIPTION,ACTIVE_RULE,DISPLAY_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('REGTN_DUPLICATE_ASSMT_RULE','RegistrationsDuplicateAssmtRule','Registration Duplicate Assessment Rule','Checks if there are duplicate in progress assessments','Y',490,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
/

DECLARE
    v_sort INTEGER;
BEGIN
    FOR x IN (SELECT DISTINCT GRADUATION_PROGRAM_CODE FROM PROGRAM_ALGORITHM_RULE) LOOP
        SELECT SORT_ORDER + 1 INTO v_sort FROM PROGRAM_ALGORITHM_RULE WHERE ALGORITHM_RULE_CODE = 'REGTN_DUPLICATE_CRSE_RULE' AND GRADUATION_PROGRAM_CODE = x.GRADUATION_PROGRAM_CODE;
        Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values (SYS_GUID(),x.GRADUATION_PROGRAM_CODE,'REGTN_DUPLICATE_ASSMT_RULE',v_sort,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
    END LOOP;
END;
/

