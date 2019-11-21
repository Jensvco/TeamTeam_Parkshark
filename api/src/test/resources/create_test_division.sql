delete from DIVISION where NAME = 'division_name';
delete from DIRECTOR where FIRST_NAME = 'firstName';

insert into DIRECTOR (ID, FIRST_NAME, LAST_NAME) values (PARKSHARK_DIRECTOR_SEQ.nextval, 'firstName', 'lastName');
insert into DIVISION (ID, NAME, ORIGINAL_NAME, DIRECTOR_ID) values (PARKSHARK_DIVISION_SEQ.nextval, 'division_name', 'original_name', (select id from DIRECTOR where FIRST_NAME = 'firstName'));
commit;