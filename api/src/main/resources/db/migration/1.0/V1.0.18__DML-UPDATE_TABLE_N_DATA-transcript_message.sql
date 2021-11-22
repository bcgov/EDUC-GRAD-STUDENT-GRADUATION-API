ALTER TABLE TRANSCRIPT_MESSAGE ADD GRAD_PROJECTED_MESSAGE VARCHAR2(500);
ALTER TABLE TRANSCRIPT_MESSAGE ADD HONOUR_PROJECTED_NOTE VARCHAR2(500);

UPDATE TRANSCRIPT_MESSAGE SET GRAD_PROJECTED_MESSAGE='Based on the information provided by the school, this student is projected to graduate in the %s',HONOUR_PROJECTED_NOTE='Based on the information provided by the school, this student is projected to graduate in the %s with Honours.' WHERE GRADUATION_PROGRAM_CODE != 'SCCP' AND MESSAGE_TYPE_CODE = 'GRADUATED';
UPDATE TRANSCRIPT_MESSAGE SET GRAD_PROJECTED_MESSAGE='Based on the information provided by the school, this student is projected to not graduate in the %s. Students with questions should contact their schools immediately.' WHERE GRADUATION_PROGRAM_CODE != 'SCCP' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';