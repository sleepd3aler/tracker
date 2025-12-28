create table if not exists items
(
    id            serial primary key,
    name          varchar(255) not null ,
    creation_time timestamp not null
);