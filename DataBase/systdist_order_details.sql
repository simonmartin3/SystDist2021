create table order_details
(
    ID         varchar(50) not null
        primary key,
    AMOUNT     double      not null,
    PRICE      double      not null,
    QUANITY    int         not null,
    ORDER_ID   varchar(50) not null,
    PRODUCT_ID varchar(20) not null,
    constraint ORDER_DETAIL_ORD_FK
        foreign key (ORDER_ID) references orders (ID),
    constraint ORDER_DETAIL_PROD_FK
        foreign key (PRODUCT_ID) references products (CODE)
);

