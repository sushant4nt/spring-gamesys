drop table if exists movies;

create table if not exists movies (
    id bigint auto_increment,
    title varchar(255),
    genre varchar(255),
    release_year smallint);