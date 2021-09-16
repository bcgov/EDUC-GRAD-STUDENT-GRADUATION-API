-- API_STUDENT_GRADUATION.UNGRAD_REASON_CODE definition

CREATE TABLE "UNGRAD_REASON_CODE"
   (	"UNGRAD_REASON_CODE" VARCHAR2(10),
	"LABEL" VARCHAR2(32) NOT NULL ENABLE,
	"DESCRIPTION" VARCHAR2(255) NOT NULL ENABLE,
	"DISPLAY_ORDER" NUMBER NOT NULL ENABLE,
	"EFFECTIVE_DATE" DATE NOT NULL ENABLE,
	"EXPIRY_DATE" DATE,
	"CREATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"CREATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	"UPDATE_USER" VARCHAR2(32) DEFAULT USER NOT NULL ENABLE,
	"UPDATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
	 CONSTRAINT "UNGRAD_REASON_CODE_PK" PRIMARY KEY ("UNGRAD_REASON_CODE")
  USING INDEX TABLESPACE "API_GRAD_IDX"  ENABLE
   ) SEGMENT CREATION IMMEDIATE
 NOCOMPRESS LOGGING
  TABLESPACE "API_GRAD_DATA"   NO INMEMORY ;