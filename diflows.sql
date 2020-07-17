drop database if exists diflows;
create database diflows;
use diflows;
create table if not exists `flowsmsg` (`timestamps` int) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# show tables;
select * from flowsmsg;
