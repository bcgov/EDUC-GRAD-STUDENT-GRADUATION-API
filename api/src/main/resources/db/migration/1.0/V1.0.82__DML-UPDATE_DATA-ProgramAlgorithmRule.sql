UPDATE PROGRAM_ALGORITHM_RULE SET SORT_ORDER = 85
WHERE GRADUATION_PROGRAM_CODE IN ('2023-EN', '2023-PF')
AND ALGORITHM_RULE_CODE = 'MATCH_CREDITS_RULE';