-- GRAD2-1548 PART 1: update PROGRAM_CADRE to null if MESSAGE_TYPE_CODE = NOT_GRADUATED
UPDATE TRANSCRIPT_MESSAGE
SET PROGRAM_CADRE = null
WHERE MESSAGE_TYPE_CODE ='NOT_GRADUATED';

-- PART 2 Modify the SCCP GRAD_MAIN_MESSAGE and GRAD_PROJECTED_MESSAGE for NOT_GRADUATED
UPDATE TRANSCRIPT_MESSAGE
SET GRAD_MAIN_MESSAGE = 'Upon completion of this student''s School Completion Certificate Program, a certificate will be issued from the Ministry of Education and Child Care for meeting their educational program goals other than graduation.',
GRAD_PROJECTED_MESSAGE = 'Upon completion of this student''s School Completion Certificate Program, a certificate will be issued from the Ministry of Education and Child Care for meeting their educational program goals other than graduation.'
WHERE GRADUATION_PROGRAM_CODE = 'SCCP' AND MESSAGE_TYPE_CODE = 'NOT_GRADUATED';
