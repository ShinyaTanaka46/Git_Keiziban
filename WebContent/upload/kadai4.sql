--‰Û‘è1
select 
	distinct prefecture
from
	zipcode
where
	prefecture = 'ŠâèŒ§';


--‰Û‘è2
select 
	distinct city
from
	zipcode
where
	city = '·‰ªs';


--‰Û‘è3
select 
	count(zipcode)
from
	zipcode
where
	prefecture = 'ŠâèŒ§';


--‰Û‘è4
select 
	count(distinct zipcode)
from
	zipcode;

--ƒ`ƒƒƒŒƒ“ƒW‰Û‘è
select 
	count(distinct (prefecture || city))
from
	zipcode;