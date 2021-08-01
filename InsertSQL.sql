insert into Accounts (USER_NAME, USER_ADDRESS, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE, USER_AMOUNT)
values ('Admin', '', 1,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER', 9999);


insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S001','iPad Pro', 899, current_timestamp);