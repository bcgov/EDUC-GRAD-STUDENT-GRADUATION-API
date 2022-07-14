-- Graduated SCCP

UPDATE TRANSCRIPT_MESSAGE SET GRAD_MAIN_MESSAGE = 'This student has been issued a School Completion Certificate, from the Ministry of Education and Child Care, for meeting their individual educational program goals. This is not a Graduation credential. ' WHERE TRANSCRIPT_MESSAGE_ID = 'C6F6F2FEC76318FCE0539AE9228E9EFD';
UPDATE TRANSCRIPT_MESSAGE SET GRAD_MAIN_MESSAGE = 'Upon completion of this student''s School Completion Certificate Program, a certificate will be issued from the Ministry of Education and Child Care for meeting their educational program goals other than graduation, as determined by the board of education.' WHERE TRANSCRIPT_MESSAGE_ID = 'C6F6F2FEC76418FCE0539AE9228E9EFD';
UPDATE TRANSCRIPT_MESSAGE SET GRAD_PROJECTED_MESSAGE = GRAD_MAIN_MESSAGE WHERE TRANSCRIPT_MESSAGE_ID = 'C6F6F2FEC76318FCE0539AE9228E9EFD';
UPDATE TRANSCRIPT_MESSAGE SET GRAD_PROJECTED_MESSAGE = GRAD_MAIN_MESSAGE WHERE TRANSCRIPT_MESSAGE_ID = 'C6F6F2FEC76418FCE0539AE9228E9EFD';
