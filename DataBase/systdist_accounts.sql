create table accounts
(
    USER_ID           int auto_increment
        primary key,
    USER_NAME         varchar(20)  not null,
    USER_LASTNAME     varchar(255) null,
    USER_ADDRESS      varchar(255) null,
    USER_CITY         varchar(255) null,
    USER_ZIP          int          null,
    ACTIVE            bit          not null,
    ENCRYTED_PASSWORD varchar(128) not null,
    USER_ROLE         varchar(20)  not null,
    USER_AMOUNT       int          null
);

INSERT INTO systdist.accounts (USER_ID, USER_NAME, USER_LASTNAME, USER_ADDRESS, USER_CITY, USER_ZIP, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE, USER_AMOUNT) VALUES (1, 'Simon', 'MARTIN', 'Rue Bois Leon 30', 'VERLAINE', 4537, true, '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE', 500);
INSERT INTO systdist.accounts (USER_ID, USER_NAME, USER_LASTNAME, USER_ADDRESS, USER_CITY, USER_ZIP, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE, USER_AMOUNT) VALUES (2, 'Admin', null, '', null, null, true, '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER', 9999);