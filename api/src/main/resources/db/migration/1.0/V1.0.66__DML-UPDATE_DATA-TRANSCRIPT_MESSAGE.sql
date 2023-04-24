UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '1996-PF' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET AD_IB_PROGRAM_MESSAGE = NULL, CAREER_PROGRAM_MESSAGE = NULL,
    GRAD_PROJECTED_MESSAGE = 'Based on the information provided by the school, this student cannot satisfy the requirements for the %s. Note: Students are no longer eligible to graduate on the 1995 graduation program unless required courses were completed by June 30, 2011. Contact your school counselor for more information.'
WHERE GRADUATION_PROGRAM_CODE = '1996-PF' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '1996-EN' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET AD_IB_PROGRAM_MESSAGE = NULL, CAREER_PROGRAM_MESSAGE = NULL,
    GRAD_PROJECTED_MESSAGE = 'Based on the information provided by the school, this student cannot satisfy the requirements for the %s. Note: Students are no longer eligible to graduate on the 1995 graduation program unless required courses were completed by June 30, 2011. Contact your school counselor for more information.'
WHERE GRADUATION_PROGRAM_CODE = '1996-EN' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '1986-EN' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET AD_IB_PROGRAM_MESSAGE = NULL, CAREER_PROGRAM_MESSAGE = NULL,
    GRAD_PROJECTED_MESSAGE = 'Based on the information provided by the school, this student cannot satisfy the requirements for the %s. Note: Students are no longer eligible to graduate on the course-based graduation program unless required courses were completed by June 30, 2001. Contact your school counselor for more information.'
WHERE GRADUATION_PROGRAM_CODE = '1986-EN' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '2018-EN' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '1950' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '2018-PF' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '2004-EN' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET AD_IB_PROGRAM_MESSAGE = NULL, CAREER_PROGRAM_MESSAGE = NULL,
    GRAD_PROJECTED_MESSAGE = 'Based on the information provided by the school, this student cannot satisfy the requirements for the %s. Note: Students are no longer eligible to graduate on the 2004 graduation program unless required courses were completed by June 30, 2021. Contact your school counselor for more information.'
WHERE GRADUATION_PROGRAM_CODE = '2004-EN' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET AD_IB_PROGRAM_MESSAGE = NULL, CAREER_PROGRAM_MESSAGE = NULL,
    GRAD_PROJECTED_MESSAGE = 'Based on the information provided by the school, this student cannot satisfy the requirements for the %s. Note: Students are no longer eligible to graduate on the 2004 graduation program unless required courses were completed by June 30, 2021. Contact your school counselor for more information.'
WHERE GRADUATION_PROGRAM_CODE = '2004-PF' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '2004-PF' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '2023-EN' AND MESSAGE_TYPE_CODE = 'GRADUATED';

UPDATE TRANSCRIPT_MESSAGE
SET CAREER_PROGRAM_MESSAGE = 'This student has also participated in Career Program(s): %s'
WHERE GRADUATION_PROGRAM_CODE = '2023-PF' AND MESSAGE_TYPE_CODE = 'GRADUATED';
