-- API_STUDENT_GRADUATION.ALGORITHM_RULE_CODE definition

CREATE TABLE "ALGORITHM_RULE_CODE"
   (	"ALGORITHM_RULE_CODE" VARCHAR2(40),
	"RULE_IMPL_NAME" VARCHAR2(50) NOT NULL ENABLE,
	"LABEL" VARCHAR2(50) NOT NULL ENABLE,
	"DESCRIPTION" VARCHAR2(255) NOT NULL ENABLE,
	"ACTIVE_RULE" VARCHAR2(1) NOT NULL ENABLE,
	"DISPLAY_ORDER" NUMBER NOT NULL ENABLE,
	"CREATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"CREATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	"UPDATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"UPDATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	 CONSTRAINT "ALGORITHM_RULE_CODE_PK" PRIMARY KEY ("ALGORITHM_RULE_CODE")
  USING INDEX TABLESPACE "API_GRAD_IDX"  ENABLE
   ) SEGMENT CREATION IMMEDIATE
 NOCOMPRESS LOGGING
  TABLESPACE "API_GRAD_DATA"   NO INMEMORY ;


