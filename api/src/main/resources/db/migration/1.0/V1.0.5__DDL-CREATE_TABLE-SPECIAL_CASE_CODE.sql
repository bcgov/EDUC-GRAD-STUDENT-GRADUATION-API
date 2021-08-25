--------------------------------------------------------
--  DDL for Table SPECIAL_CASE_CODE
--------------------------------------------------------

CREATE TABLE "SPECIAL_CASE_CODE"
(	"SPECIAL_CASE_CODE" VARCHAR2(2 BYTE),
     "LABEL" VARCHAR2(30 BYTE) NOT NULL ENABLE,
     "DESCRIPTION" VARCHAR2(255 BYTE) NOT NULL ENABLE,
     "DISPLAY_ORDER" NUMBER NOT NULL ENABLE,
     "PASS_FLAG" VARCHAR2(1 BYTE),
     "EFFECTIVE_DATE" DATE NOT NULL ENABLE,
     "EXPIRY_DATE" DATE,
     "CREATE_USER" VARCHAR2(32 BYTE) DEFAULT USER NOT NULL ENABLE,
     "CREATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
     "UPDATE_USER" VARCHAR2(32 BYTE) DEFAULT USER NOT NULL ENABLE,
     "UPDATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
     CONSTRAINT "SPECIAL_CASE_CODE_PK" PRIMARY KEY ("SPECIAL_CASE_CODE")
         USING INDEX
             TABLESPACE "API_GRAD_DATA"  ENABLE
) SEGMENT CREATION IMMEDIATE
    NOCOMPRESS LOGGING
    TABLESPACE "API_GRAD_DATA"   NO INMEMORY ;
