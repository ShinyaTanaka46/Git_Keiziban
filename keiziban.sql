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


INSERT INTO keiziban VALUES(1,'太郎君','aaa@morijyobi.ac.jp','モリジョビは楽しいよ','2020/05/20 14:35:16','','');
INSERT INTO keiziban(name,mail,content,time,updtime) VALUES('タナカブラザーズ','bbb@morijyobi.ac.jp','モリジョビは最高','2020/05/24 10:15:10','');
INSERT INTO keiziban(name,mail,content,time,updtime) VALUES('書き込みくん','ccc@morijyobi.ac.jp','実際先生次第','2020/05/26 22:42:58','');