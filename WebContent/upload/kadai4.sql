--�ۑ�1
select 
	distinct prefecture
from
	zipcode
where
	prefecture = '��茧';


--�ۑ�2
select 
	distinct city
from
	zipcode
where
	city = '�����s';


--�ۑ�3
select 
	count(zipcode)
from
	zipcode
where
	prefecture = '��茧';


--�ۑ�4
select 
	count(distinct zipcode)
from
	zipcode;

--�`�������W�ۑ�
select 
	count(distinct (prefecture || city))
from
	zipcode;