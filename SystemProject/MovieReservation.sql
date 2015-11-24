create database MovieReservation

use moviereservation
use database

show tables

create table userData(

ID			varchar(20) primary key,
PWD			varchar(20),
REPWD		varchar(20),
NAME		varchar(20),
GENDER		varchar(10)
)

select * from userData
select * from movie

show databases
drop table movie;

create table movie(

director	varchar(100),
actor		varchar(100),
genre		varchar(100),
mtime		varchar(100),
mdate		varchar(100),
banch		varchar(100),
movieName	varchar(100)
)