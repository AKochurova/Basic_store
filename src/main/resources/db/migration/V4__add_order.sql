

create table usr_order (
    id int8 not null,
    user_id int8,
    total int8,
    primary key (id)
);


alter table if exists usr_order
    add constraint usr_order_user_fk
    foreign key (user_id) references usr;

