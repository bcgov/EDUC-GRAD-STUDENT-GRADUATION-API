UPDATE ALGORITHM_RULE_CODE SET DESCRIPTION = 'Of the five courses required for the Adult Dogwood, at least three must be completed after a student has turned 18 if a student’s projected grade date is > = 2012/07' WHERE ALGORITHM_RULE_CODE = 'MIN_ADULT_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET DESCRIPTION = 'Of the five courses required for the Adult Dogwood, at least three must be completed after a student has turned 19  if a student’s projected grade date is < 2012/07' WHERE ALGORITHM_RULE_CODE = 'MIN_ADULT_CRSE_RULE_19';