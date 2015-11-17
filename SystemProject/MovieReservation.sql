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

create table movie(
movieName	varchar(100),
director	varchar(100),
genre		varchar(100),
mtime		varchar(100),
actor		varchar(100),
banch		varchar(100),
mdate		varchar(100)
)