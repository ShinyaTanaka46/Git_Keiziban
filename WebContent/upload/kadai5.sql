--�ۑ�1
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
	values('���',150,10,'2012-07-01','�X�Y');
insert into zaiko(name,price,stock,arrival) 
	values('�݂���',80,30,'2012-07-02');

--�ۑ�2
grant select,delete,update,insert on zaiko to ossdb;
grant select,delete,update,insert on zaiko_id_seq to ossdb;

insert into zaiko(name,price,stock,arrival,remarks) 
	values('�΂Ȃ�',180,40,'2012-07-22','�t�B���s���Y');
delete from zaiko where remarks = '�X�Y';