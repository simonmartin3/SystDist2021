create table orders
(
    ID         varchar(50) not null
        primary key,
    USER_ID    int         null,
    AMOUNT     double      not null,
    ORDER_DATE datetime    not null,
    STATUS     int         null,
    constraint orders_accounts_USER_ID_fk
        foreign key (USER_ID) references accounts (USER_ID)
            on update cascade on delete cascade
);

