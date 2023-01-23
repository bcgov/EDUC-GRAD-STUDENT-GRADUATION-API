UPDATE TRANSCRIPT_MESSAGE
SET GRAD_MAIN_MESSAGE='Based on the information provided by the school, this student has graduated in the %s.'
WHERE MESSAGE_TYPE_CODE = 'GRADUATED' AND GRADUATION_PROGRAM_CODE NOT IN ('SCCP', 'NOPROG');