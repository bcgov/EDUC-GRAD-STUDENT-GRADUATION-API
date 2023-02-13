UPDATE TRANSCRIPT_MESSAGE
SET GRAD_MAIN_MESSAGE = 'Based on the information provided by the school, this student has not yet graduated in the %s. Students with questions should contact their schools immediately.'
WHERE GRADUATION_PROGRAM_CODE = '1950' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';