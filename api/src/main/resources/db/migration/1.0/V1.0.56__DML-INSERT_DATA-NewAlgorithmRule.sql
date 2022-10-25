INSERT INTO ALGORITHM_RULE_CODE (ALGORITHM_RULE_CODE, RULE_IMPL_NAME, LABEL, DESCRIPTION, ACTIVE_RULE, DISPLAY_ORDER) VALUES('ADULT_SG_RULE', 'AdultStudentGradeRule', 'Adult student must be in grade AD', 'Adult student must be in grade AD', 'Y', 540);

INSERT INTO PROGRAM_ALGORITHM_RULE (PROGRAM_ALGO_RULE_ID, GRADUATION_PROGRAM_CODE, ALGORITHM_RULE_CODE, SORT_ORDER) VALUES('EBDDE1B156B633A4E0539AE9228ECE7B', '1950', 'ADULT_SG_RULE', 160);