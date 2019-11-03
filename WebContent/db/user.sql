create user serviceFood identified by service; 
GRANT create session to serviceFood; 
grant create table, create view to serviceFood with admin option;
GRANT CONNECT, RESOURCE, DBA TO serviceFood;

grant alter on cliente to serviceFood;
GRANT select, update, delete, insert ON cliente to serviceFood;

grant all privileges to serviceFood identified by service;