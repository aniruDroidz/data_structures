create database college;

use college;

create table student(
	id int primary key,
    name varchar(50),
    age int not null
);

insert into student values(1, "Aman", 26);
insert into student values(2, "Shraddha", 24);

select * from student;