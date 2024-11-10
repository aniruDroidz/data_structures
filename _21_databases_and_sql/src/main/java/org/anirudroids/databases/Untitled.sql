
# General order
# select column(s)
# from table_name
# where condition
# group by column(s)
# having condition
# order by column(s) asc;

create database if not exists college;

use college;

create table student(
rollno int primary key,
name varchar(50),
marks int not null,
grade varchar(1),
city varchar(20)
);

insert into student(
rollno, name, marks, grade, city
)
values
(101, "anil", 78, "C", "Pune"),
(102, "bhumika", 93, "A", "Mumbai"),
(103, "chetan", 85, "B", "Mumbai"),
(104, "dhruv", 96, "A", "Delhi"),
(105, "emnuel", 12, "F", "Delhi"),
(106, "farah", 82, "B", "Delhi");

select * from student;

# distinct
select distinct city from student;

# where

select * 
from student 
where marks > 80;

select * 
from student
where marks > 80 and city = "Mumbai";

select *
from student
where marks+10 > 100;

select *
from student
where marks = 93;

select *
from student
where marks > 90;

select * 
from student
where marks > 80 or city = "Mumbai";

select *
from student
where marks between 80 and 90;

select *
from student
where city in ("Delhi", "Mumbai", "Gurgaon");

select *
from student
where city not in ("Delhi", "Mumbai", "Gurgaon");

select *
from student
where marks > 75
limit 3;

# order by

select *
from student
where marks > 75
order by city asc
limit 3;

select *
from student
order by marks desc
limit 3;

# Aggregate functions
select count(*)
from student;

select max(marks)
from student;

select avg(marks)
from student;

# group by
select city, count(rollno)
from student
group by city;

select city, name, count(rollno)
from student
group by city, name;

select city, avg(marks)
from student
group by city
order by avg(marks) desc;

select grade, count(*)
from student
group by grade
order by grade;

# having - to apply conditions on groups
select count(*), city
from student
group by city
having max(marks) > 90;

select city
from student
where grade = "A"
group by city
having max(marks) >= 93
order by city desc;

# Update
# update table_name
# set col1 = val1, col2 = val2
# where condition;

update student
set grade = "O"
where grade = "A";

set sql_safe_updates = 0;

update student
set grade = "O"
where grade = "A";

update student
set marks = 12
where rollno = 105;

update student
set grade = "B"
where marks between 80 and 90;

update student
set marks = marks + 1
where marks between 80 and 90;

# Delete
# delete from table_name
# where condition;

delete from student
where marks < 33;

select * from student;

# Foreign key
create table dept (
	id int primary key,
    name varchar(50)
);

create table teacher(
	id int primary key,
    name varchar(50),
    dept_id int,
    foreign key(dept_id) references dept(id)
);

# Cascading for foreign keys

drop table teacher;

create table teacher(
	id int primary key,
    name varchar(50),
    dept_id int,
    foreign key(dept_id) references dept(id)
    on delete cascade
    on update cascade
);

insert into dept
values
(101, "english"),
(102, "IT");

insert into teacher
values
(101, "Adam", 101),
(102, "Eve", 102);

update dept
set id = 111
where id = 101;

select * from teacher;