UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Aegrotat Standing – the student has been excused from writing a Provincial Graduation Assessment due to unpredictable circumstances that render the student unable to write it, even at a future session.'
WHERE SPECIAL_CASE_CODE = 'A';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Non-Complete – the student did not complete enough of the assessment to generate a proficiency score.'
WHERE SPECIAL_CASE_CODE = 'X';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Assessment requirement exempt.'
WHERE SPECIAL_CASE_CODE = 'E';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Disqualification – an assessment is disqualified when the assessment rules are breached. No mark is given for the assessment.'
WHERE SPECIAL_CASE_CODE = 'Q';


