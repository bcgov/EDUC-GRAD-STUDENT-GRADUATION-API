ALTER TABLE API_STUDENT_GRADUATION.STUDENT_UNGRAD_REASON RENAME TO STUDENT_UNDO_COMPLETION_REASON;
ALTER TABLE API_STUDENT_GRADUATION.STUDENT_UNDO_COMPLETION_REASON RENAME COLUMN UNGRAD_REASON_DESCRIPTION TO UNDO_COMPLETION_REASON_DESCRIPTION;
ALTER TABLE API_STUDENT_GRADUATION.STUDENT_UNDO_COMPLETION_REASON RENAME COLUMN UNGRAD_REASON_CODE TO UNDO_COMPLETION_REASON_CODE;
ALTER TABLE API_STUDENT_GRADUATION.STUDENT_UNDO_COMPLETION_REASON RENAME COLUMN STUDENT_UNGRAD_REASON_ID TO STUDENT_UNDO_COMPLETION_REASON_ID;
ALTER TABLE API_STUDENT_GRADUATION.UNGRAD_REASON_CODE RENAME TO UNDO_COMPLETION_REASON_CODE;
ALTER TABLE API_STUDENT_GRADUATION.UNDO_COMPLETION_REASON_CODE RENAME COLUMN UNGRAD_REASON_CODE TO UNDO_COMPLETION_REASON_CODE;