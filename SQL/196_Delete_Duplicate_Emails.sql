delete p1
from Person p1, Person p2
where p1.Email = p2.Email and p1.Id > p2.Id;

delete from Person
where Id not in (
    select temp.id from (select min(p.Id) as Id from Person p group by Email) temp
);

