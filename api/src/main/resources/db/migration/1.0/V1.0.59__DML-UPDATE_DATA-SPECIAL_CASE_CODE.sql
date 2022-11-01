-- GRAD2-1582, add new descriptions to codes:
UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Not Completed. Student attempted to write but did not complete enough of the Provincial Graduation Assessment to obtain a proficiency score.'
WHERE SPECIAL_CASE_CODE = 'X';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Disqualified. Student is believed to have breached one or more rules during a Provincial Graduation Assessment.'
WHERE SPECIAL_CASE_CODE = 'Q';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'The Assessment requirement has been met by a Provincial Exam.'
WHERE SPECIAL_CASE_CODE = 'M';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Assessment requirement exempt.'
WHERE SPECIAL_CASE_CODE = 'E';

UPDATE SPECIAL_CASE_CODE
SET DESCRIPTION = 'Aegrotat Standing. The student has been granted exemption from writing a Provincial Graduation Assessment due to unpredictable circumstances that render a student unable to write an assessment, even at a future session.'
WHERE SPECIAL_CASE_CODE = 'A';

