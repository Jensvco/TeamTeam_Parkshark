CREATE TABLE PARKING_LOT
(
    ID INT NOT NULL
    , NAME VARCHAR2(20) NOT NULL
    , PARKING_LOT_CATEGORY_ID INT NOT NULL
    , CAPACITY INT NOT NULL
    , CONTACT_PERSON_ID INT NOT NULL
    , ADDRESS_ID INT NOT NULL
    , PRICE_PER_HOUR NUMBER NOT NULL
    , CONSTRAINT PARKING_LOT_PK PRIMARY KEY
    (
     ID
        )
    ENABLE
);

CREATE TABLE CONTACT_PERSON
(
    ID INT NOT NULL
    , NAME VARCHAR2(20) NOT NULL
    , EMAIL VARCHAR2(50) NOT NULL
    , ADDRESS_ID INT NOT NULL
    , CONSTRAINT CONTACT_PERSON_PK PRIMARY KEY
    (
     ID
        )
    ENABLE
);

CREATE TABLE PARKING_LOT_CATEGORY
(
    ID INT NOT NULL
    , CATEGORY_NAME VARCHAR2(30)
    , CONSTRAINT PARKING_LOT_CATEGORY_PK PRIMARY KEY
    (
     ID
        )
    ENABLE
);

CREATE TABLE PHONE_NUMBER
(
    ID INT NOT NULL
    ,CONTACT_PERSON_ID INT NOT NULL
    , PHONE_NUMBER VARCHAR2(20) NOT NULL
    , PHONE_NUMBER_TYPE VARCHAR2(20) NOT NULL
    , CONSTRAINT PHONE_NUMBER_PK PRIMARY KEY
    (
     ID
        )
    ENABLE
);

CREATE TABLE ADDRESS
(
    ID INT NOT NULL
    , STREET_NAME VARCHAR2(30) NOT NULL
    , HOUSE_NUMBER VARCHAR2(10) NOT NULL
    , POSTAL_CODE VARCHAR2(10) NOT NULL
    , CITY VARCHAR2(30) NOT NULL
    , CONSTRAINT ADDRESS_PK PRIMARY KEY
    (
     ID
        )
    ENABLE
);

alter table "HRSTUDENT7"."PHONE_NUMBER" add constraint PHONE_NUMBER_CONTACT_PERSON_FK foreign key("CONTACT_PERSON_ID") references "CONTACT_PERSON"("ID");

alter table "HRSTUDENT7"."PARKING_LOT" add constraint PARKING_LOT_PARKING_CAT_FK foreign key("PARKING_LOT_CATEGORY_ID") references "PARKING_LOT_CATEGORY"("ID");

alter table "HRSTUDENT7"."CONTACT_PERSON" add constraint CONTACT_PERSON_ADDRESS_FK foreign key("ADDRESS_ID") references "ADDRESS"("ID");

alter table "HRSTUDENT7"."PARKING_LOT" add constraint PARKING_LOT_CONTACT_PERSON_FK foreign key("CONTACT_PERSON_ID") references "CONTACT_PERSON"("ID");
