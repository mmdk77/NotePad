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

--영화정보 삽입.
insert into movie values('이준익','송강호,유아인 외','드라마','125분','2015.09.16','100','사도');
insert into movie values('류승완','황정민,유아인 외',',액션,드라마','123분','2015.08.05','100','베테랑');
insert into movie values('웨스볼','딜런 오브라이언,토마스 생스터 외','액션,SF','132분','2015.09.16','100','메이즈러너');
insert into movie values('김정훈','권상우,성동일 외','코미디,범죄','120분','2015.09.24','100','탐정');
insert into movie values('최동훈','이정재,전지현 외','액션,드라마','139분','2015.07.22','100','암살');