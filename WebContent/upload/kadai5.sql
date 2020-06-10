--‰Û‘è1
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
	values('‚è‚ñ‚²',150,10,'2012-07-01','ÂXY');
insert into zaiko(name,price,stock,arrival) 
	values('‚İ‚©‚ñ',80,30,'2012-07-02');

--‰Û‘è2
grant select,delete,update,insert on zaiko to ossdb;
grant select,delete,update,insert on zaiko_id_seq to ossdb;

insert into zaiko(name,price,stock,arrival,remarks) 
	values('‚Î‚È‚È',180,40,'2012-07-22','ƒtƒBƒŠƒsƒ“Y');
delete from zaiko where remarks = 'ÂXY';