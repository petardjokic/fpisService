create table workers(
	id number primary key,
	first_name varchar2(100) not null,
	last_name varchar2(100) not null,
	position varchar2(100) not null
);
create sequence sq_workers;

create table products(
	id number primary key,
	name varchar2(100) not null
);
create sequence sq_products;