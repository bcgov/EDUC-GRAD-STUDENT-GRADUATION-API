ALTER TABLE "TRANSCRIPT_MESSAGE" ADD (
    "GRADUATION_SCHOOL" VARCHAR2(50)
);
UPDATE TRANSCRIPT_MESSAGE SET GRADUATION_SCHOOL = 'Graduation School: %s' WHERE MESSAGE_TYPE_CODE = 'GRADUATED';
