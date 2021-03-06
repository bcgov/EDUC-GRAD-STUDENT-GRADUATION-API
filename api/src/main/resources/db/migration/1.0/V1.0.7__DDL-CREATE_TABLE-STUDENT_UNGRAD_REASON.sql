-- API_STUDENT_GRADUATION.STUDENT_UNGRAD_REASON definition

CREATE TABLE "STUDENT_UNGRAD_REASON"
   (	"STUDENT_UNGRAD_REASON_ID" RAW(16) DEFAULT SYS_GUID(),
	"UNGRAD_REASON_CODE" VARCHAR2(20) NOT NULL ENABLE,
	"GRADUATION_STUDENT_RECORD_ID" RAW(16) NOT NULL ENABLE,
	"UNGRAD_REASON_DESCRIPTION" VARCHAR2(255),
	"CREATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"CREATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	"UPDATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"UPDATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	 CONSTRAINT "STUDENT_UNGRAD_REASON_PK" PRIMARY KEY ("STUDENT_UNGRAD_REASON_ID")
  USING INDEX TABLESPACE "API_GRAD_IDX"  ENABLE,
	 CONSTRAINT "STUD_UNGR_RSN_UGRD_RSNCD_FK" FOREIGN KEY ("UNGRAD_REASON_CODE")
	  REFERENCES "UNGRAD_REASON_CODE" ("UNGRAD_REASON_CODE") ENABLE
   ) SEGMENT CREATION IMMEDIATE
 NOCOMPRESS LOGGING
  TABLESPACE "API_GRAD_DATA"   NO INMEMORY ;