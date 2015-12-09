drop table itemPurchase; 
drop table purchase; 
drop table book; 
drop table item;    

create table item (
	upc char(6), 
	sellingPrice float not null, 
	stock int not null, 
	taxable char(1) not null, 
	primary key(upc), 
	check(LOWER(taxable) IN ('y','n')), 
	check (stock>=0)
);  

create table book (
	upc char(6), 
	title varchar(50) not null, 
	publisher varchar(50) not null, 
	flag_text char(1) not null, 
	primary key(upc), 
	foreign key(upc) references item, 
	check(LOWER(flag_text) IN ('y','n'))
);  

create table purchase (
	t_id char(6), 
	purchaseDate date not null, 
	totalamt float not null, 
	pur_type varchar(15) not null, 
	cardno char(12), 
	cardtype varchar(12), 
	primary key(t_id), 
	check(LOWER(pur_type) IN ('cash','credit card')), 
	check(totalamt>=0) 
);  

create table itemPurchase ( 
	t_id char(6), 
	upc char(6), 
	quantity float not null, 
	primary key(t_id,upc), 
	foreign key(t_id) references purchase, 
	foreign key(upc) references item, 
	check(quantity>=0) 
);

INSERT INTO ITEM VALUES('a00001',50,100,'y');
INSERT INTO ITEM VALUES('a00002',60,500,'y');
INSERT INTO ITEM VALUES('a00003',64,200,'n');
INSERT INTO ITEM VALUES('a00004',800,500,'y');
INSERT INTO ITEM VALUES('a00005',56,130,'n');
INSERT INTO ITEM VALUES('a00006',66,300,'n');
INSERT INTO ITEM VALUES('a00007',123,320,'y');
INSERT INTO ITEM VALUES('a00008',100,125,'y');
INSERT INTO ITEM VALUES('a00009',99,159,'n');
INSERT INTO ITEM VALUES('a00010',76,123,'y');
INSERT INTO ITEM VALUES('a00011',88,144,'n');
INSERT INTO ITEM VALUES('a00012',50,264,'y');
INSERT INTO ITEM VALUES('a00013',74,155,'y');
INSERT INTO ITEM VALUES('a00014',24,160,'y');
INSERT INTO ITEM VALUES('a00015',15,8,'n');
INSERT INTO ITEM VALUES('a00016',10,6,'y');
INSERT INTO ITEM VALUES('a00017',34,5,'n');
INSERT INTO ITEM VALUES('a00018',1000,200,'y');
INSERT INTO ITEM VALUES('a00019',112,150,'n');
INSERT INTO ITEM VALUES('a00020',44,2,'n');
INSERT INTO ITEM VALUES('a00021',99,0,'y');

INSERT INTO BOOK VALUES('a00002','Secrets of Silicon Valley','New Age Books','n');
INSERT INTO BOOK VALUES('a00005','Introduciton to Artificial Intelligence','Pearson','y');
INSERT INTO BOOK VALUES('a00007','Art of Programming','McGraw Hill','y');
INSERT INTO BOOK VALUES('a00012','Digital Image Processing','Pearson','y');
INSERT INTO BOOK VALUES('a00009','The Martian','New Age Books','y');
INSERT INTO BOOK VALUES('a00014','Electromagnetism','McGraw Hill','y');
INSERT INTO BOOK VALUES('a00013','Prolonged Data Deprivation: Four Case Studies','McGraw Hill','y');
INSERT INTO BOOK VALUES('a00001','The Kite Runner','New Age Books','n');
INSERT INTO BOOK VALUES('a00015','History of Civilization','Pearson','y');
INSERT INTO BOOK VALUES('a00016','Microcontroller Programming','McGraw Hill','y');
INSERT INTO BOOK VALUES('a00017','Introduction to Computational Neuroscience','Pearson','y');

INSERT INTO PURCHASE VALUES('p00001','15-OCT-26',1300,'cash',null,null);
INSERT INTO PURCHASE VALUES('p00002','15-OCT-29',2400,'credit card','231242123123','visa');
INSERT INTO PURCHASE VALUES('p00003','15-OCT-27',1000,'credit card','341231234412','mastercard');
INSERT INTO PURCHASE VALUES('p00004','15-OCT-28',1500,'cash',null,null);
INSERT INTO PURCHASE VALUES('p00005','15-OCT-30',1800,'cash',null,null);
INSERT INTO PURCHASE VALUES('p00006','15-OCT-18',2000,'credit card','123313341234','mastercard');
INSERT INTO PURCHASE VALUES('p00007','15-OCT-10',1800,'cash',null,null);
INSERT INTO PURCHASE VALUES('p00008','15-OCT-12',1600,'cash',null,null);
INSERT INTO PURCHASE VALUES('p00009','15-OCT-30',1800,'cash',null,null);
INSERT INTO PURCHASE VALUES('p00010','15-OCT-29',1500,'cash',null,null);

INSERT INTO ITEMPURCHASE VALUES('p00001','a00016',20);
INSERT INTO ITEMPURCHASE VALUES('p00003','a00016',24);
INSERT INTO ITEMPURCHASE VALUES('p00004','a00016',40);
INSERT INTO ITEMPURCHASE VALUES('p00005','a00007',10);
INSERT INTO ITEMPURCHASE VALUES('p00004','a00007',14);
INSERT INTO ITEMPURCHASE VALUES('p00006','a00007',50);
INSERT INTO ITEMPURCHASE VALUES('p00002','a00017',100);
INSERT INTO ITEMPURCHASE VALUES('p00005','a00015',30);
INSERT INTO ITEMPURCHASE VALUES('p00001','a00015',40);
INSERT INTO ITEMPURCHASE VALUES('p00005','a00016',70);
INSERT INTO ITEMPURCHASE VALUES('p00001','a00014',40);
INSERT INTO ITEMPURCHASE VALUES('p00003','a00014',10);
INSERT INTO ITEMPURCHASE VALUES('p00004','a00014',15);
INSERT INTO ITEMPURCHASE VALUES('p00005','a00001',50);
INSERT INTO ITEMPURCHASE VALUES('p00004','a00001',20);
INSERT INTO ITEMPURCHASE VALUES('p00006','a00002',100);
INSERT INTO ITEMPURCHASE VALUES('p00006','a00009',100);
INSERT INTO ITEMPURCHASE VALUES('p00005','a00009',40);

INSERT INTO ITEMPURCHASE VALUES('p00007','a00020',80);
INSERT INTO ITEMPURCHASE VALUES('p00008','a00021',60);
INSERT INTO ITEMPURCHASE VALUES('p00002','a00018',5);
INSERT INTO ITEMPURCHASE VALUES('p00009','a00004',4);
INSERT INTO ITEMPURCHASE VALUES('p00010','a00004',4);