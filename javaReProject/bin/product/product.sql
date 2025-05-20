-- DB 생성
create database javadb;

-- user 설정
create user 'javauser'@'localhost' identified by 'mysql';

-- 유저 권한 부여
grant all privileges on javadb.* to 'javauser'@'localhost';
flush privileges;

-- 테이블 생성
create table product(
pno int auto_increment,
pname varchar(100) not null,
price int default 0,
regdate datetime default now(),
madeby text,
primary key(pno)
);