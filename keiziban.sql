use javakadai;

create table keiziban(
 id int(32) auto_increment,
 name varchar(32) not null,
 mail varchar(60) not null,
 content varchar(400) not null,
 time varchar(19) not null,
 updtime varchar(19),
 imgname varchar(128),
 primary key(id)
);


INSERT INTO keiziban VALUES(1,'���Y�N','aaa@morijyobi.ac.jp','�����W���r�͊y������','2020/05/20 14:35:16','','');
INSERT INTO keiziban(name,mail,content,time,updtime) VALUES('�^�i�J�u���U�[�Y','bbb@morijyobi.ac.jp','�����W���r�͍ō�','2020/05/24 10:15:10','');
INSERT INTO keiziban(name,mail,content,time,updtime) VALUES('�������݂���','ccc@morijyobi.ac.jp','���ې搶����','2020/05/26 22:42:58','');