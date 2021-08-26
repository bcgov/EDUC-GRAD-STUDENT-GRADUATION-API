--------------------------------------------------------
--  File created - Tuesday-August-10-2021
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MESSAGE_TYPE_CODE
--------------------------------------------------------

CREATE TABLE "MESSAGE_TYPE_CODE"
(	"MESSAGE_TYPE_CODE" VARCHAR2(30 BYTE),
     "LABEL" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "DESCRIPTION" VARCHAR2(255 BYTE) NOT NULL ENABLE,
     "DISPLAY_ORDER" NUMBER NOT NULL ENABLE,
     "EFFECTIVE_DATE" DATE NOT NULL ENABLE,
     "EXPIRY_DATE" DATE,
     "CREATE_USER" VARCHAR2(32 BYTE) DEFAULT USER NOT NULL ENABLE,
     "CREATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
     "UPDATE_USER" VARCHAR2(32 BYTE) DEFAULT USER NOT NULL ENABLE,
     "UPDATE_DATE" DATE DEFAULT SYSTIMESTAMP NOT NULL ENABLE,
     CONSTRAINT "MESSAGE_TYPE_CODE_PK" PRIMARY KEY ("MESSAGE_TYPE_CODE")
         USING INDEX
             TABLESPACE "API_GRAD_DATA"  ENABLE
) SEGMENT CREATION IMMEDIATE
    NOCOMPRESS LOGGING
    TABLESPACE "API_GRAD_DATA"   NO INMEMORY ;


