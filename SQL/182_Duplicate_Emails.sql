drop table If Exists Person;
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values ('1', 'a@b.com');
insert into Person (Id, Email) values ('2', 'c@d.com');
insert into Person (Id, Email) values ('3', 'a@b.com');

select distinct(p1.Email) as Email
from Person p1 join Person p2 on (p1.Email = p2.Email and p1.Id != p2.Id)
where p1.Email = p2.Email;

select Email from Person
group by Email
having count(Email) > 1;
