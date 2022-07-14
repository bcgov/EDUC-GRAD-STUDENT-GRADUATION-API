Insert into ALGORITHM_RULE_CODE (ALGORITHM_RULE_CODE,RULE_IMPL_NAME,LABEL,DESCRIPTION,ACTIVE_RULE,DISPLAY_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('REGTN_DUPLICATE_ASSMT_RULE','RegistrationsDuplicateAssmtRule','Registration Duplicate Assessment Rule','Checks if there are duplicate in progress assessments','Y',490,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into ALGORITHM_RULE_CODE (ALGORITHM_RULE_CODE,RULE_IMPL_NAME,LABEL,DESCRIPTION,ACTIVE_RULE,DISPLAY_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('REGTN_DUPLICATE_CRSE_RULE','RegistrationsDuplicateCrseRule','Registration Duplicate Course Rule','Checks if there are duplicate in progress courses','Y',500,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));

Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599363AFE05398E9228EFA0A','2018-EN','REGTN_DUPLICATE_ASSMT_RULE',23,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599463AFE05398E9228EFA0A','2018-PF','REGTN_DUPLICATE_ASSMT_RULE',23,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599563AFE05398E9228EFA0A','2004-EN','REGTN_DUPLICATE_ASSMT_RULE',23,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599663AFE05398E9228EFA0A','2004-PF','REGTN_DUPLICATE_ASSMT_RULE',23,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599763AFE05398E9228EFA0A','1996-EN','REGTN_DUPLICATE_ASSMT_RULE',22,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599863AFE05398E9228EFA0A','1996-PF','REGTN_DUPLICATE_ASSMT_RULE',22,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599963AFE05398E9228EFA0A','1986-EN','REGTN_DUPLICATE_ASSMT_RULE',22,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599A63AFE05398E9228EFA0A','1950','REGTN_DUPLICATE_ASSMT_RULE',23,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));
Insert into PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID,GRADUATION_PROGRAM_CODE,ALGORITHM_RULE_CODE,SORT_ORDER,CREATE_USER,CREATE_DATE,UPDATE_USER,UPDATE_DATE) values ('E1EC9A45599B63AFE05398E9228EFA0A','SCCP','REGTN_DUPLICATE_ASSMT_RULE',23,'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'),'API_STUDENT_GRADUATION',to_date('22-06-16','RR-MM-DD'));

UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5A983EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5AA83EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5AB83EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5AC83EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5AD83EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5AE83EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5AF83EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5B083EFE0539AE9228E5807';
UPDATE PROGRAM_ALGORITHM_RULE SET ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE' WHERE PROGRAM_ALGO_RULE_ID='DC9F3DC7F5B183EFE0539AE9228E5807';

DELETE FROM ALGORITHM_RULE_CODE WHERE ALGORITHM_RULE_CODE ='REGTN_DUPLICATE_RULE';