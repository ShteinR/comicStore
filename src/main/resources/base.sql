create database comicstore;
use comicstore;

create table user
(
    id            mediumint auto_increment primary key,
    active        bit(1),
    roles         varchar(255),
    user_name     varchar(255),
    user_password varchar(255)
);

/*после запуска программы просто чтобы заполнить таблицу
insert into user VALUE (1,1,'ROLE_USER','user','pass');
insert into user VALUE (2,1,'ROLE_ADMIN','admin','adminpass');
insert into products VALUE (1,'first','spiderMan2099.jpg','spiderman',12,1,1);
insert into artists value (1,47,'artists name');
insert into authors value (1,34,'authors name');*/