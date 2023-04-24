DELETE FROM PROGRAM_ALGORITHM_RULE WHERE PROGRAM_ALGO_RULE_ID='C962B9A501B1A3DBE05398E9228E703D';

DELETE FROM ALGORITHM_RULE_CODE WHERE ALGORITHM_RULE_CODE='MIN_ADULT_CRSE_RULE_19';

UPDATE ALGORITHM_RULE_CODE
SET LABEL='Min Adult Courses rule',
    DESCRIPTION='Of the five courses required for the Adult Dogwood, at least three must be completed after the date Student entered the Adult Graduation Program'
WHERE ALGORITHM_RULE_CODE='MIN_ADULT_CRSE_RULE';