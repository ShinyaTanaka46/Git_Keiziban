--課題1
create database practice;

create table zaiko (
	id serial,
	name varchar(32),
	price int,
	stock int,
	arrival date,
	remarks varchar(32),
	primary key(id)
);

insert into zaiko(name,price,stock,arrival,remarks) 
	values('りんご',150,10,'2012-07-01','青森産');
insert into zaiko(name,price,stock,arrival) 
	values('みかん',80,30,'2012-07-02');

--課題2
grant select,delete,update,insert on zaiko to ossdb;
grant select,delete,update,insert on zaiko_id_seq to ossdb;

insert into zaiko(name,price,stock,arrival,remarks) 
	values('ばなな',180,40,'2012-07-22','フィリピン産');
delete from zaiko where remarks = '青森産';