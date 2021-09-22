-- API_STUDENT_GRADUATION.PROGRAM_ALGORITHM_RULE definition

CREATE TABLE "PROGRAM_ALGORITHM_RULE"
   (	"PROGRAM_ALGO_RULE_ID" RAW(16) DEFAULT SYS_GUID(),
	"GRADUATION_PROGRAM_CODE" VARCHAR2(8) NOT NULL ENABLE,
	"ALGORITHM_RULE_CODE" VARCHAR2(35) NOT NULL ENABLE,
	"SORT_ORDER" NUMBER,
	"CREATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"CREATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	"UPDATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"UPDATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	 CONSTRAINT "PROGRAM_ALGORITHM_RULE_PK" PRIMARY KEY ("PROGRAM_ALGO_RULE_ID")
  USING INDEX TABLESPACE "API_GRAD_IDX"  ENABLE,
	 CONSTRAINT "PGM_ALGORLE_ALGO_RUECD_FK" FOREIGN KEY ("ALGORITHM_RULE_CODE")
	  REFERENCES "ALGORITHM_RULE_CODE" ("ALGORITHM_RULE_CODE") ENABLE
   ) SEGMENT CREATION IMMEDIATE
 NOCOMPRESS LOGGING
  TABLESPACE "API_GRAD_DATA"   NO INMEMORY ;