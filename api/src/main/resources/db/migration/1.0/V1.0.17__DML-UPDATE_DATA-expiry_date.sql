UPDATE LETTER_GRADE SET EXPIRY_DATE = NULL WHERE to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '2099-12-31' OR to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '1999-12-31';
UPDATE MESSAGE_TYPE_CODE SET EXPIRY_DATE = NULL WHERE to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '2099-12-31' OR to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '1999-12-31';
UPDATE SPECIAL_CASE_CODE SET EXPIRY_DATE = NULL WHERE to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '2099-12-31' OR to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '1999-12-31';
UPDATE UNGRAD_REASON_CODE SET EXPIRY_DATE = NULL WHERE to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '2099-12-31' OR to_char(EXPIRY_DATE, 'yyyy-mm-dd') = '1999-12-31';

UPDATE API_STUDENT_GRADUATION.LETTER_GRADE x SET x.EXPIRY_DATE=TIMESTAMP'1994-08-31 00:00:00.0' WHERE x.LETTER_GRADE='P';