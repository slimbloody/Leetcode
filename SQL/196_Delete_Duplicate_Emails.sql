drop table If Exists Person;
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values ('1', 'john@example.com');
insert into Person (Id, Email) values ('2', 'bob@example.com');
insert into Person (Id, Email) values ('3', 'john@example.com');

delete from Person
where Person.Id not in (
  select temp.id from
  (select min(p.Id) as Id from Person p group by p.Email) temp
);

DELETE p1
FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND
p1.Id > p2.Id;

with toDeleteIds as
(
    select p1.id
    from person p1 join person p2
    on p1.email = p2.email and p1.id > p2.id
)
delete
from person
where id in (select id from toDeleteIds)



