DROP table Person;
DROP table Address;
Create table Person (PersonId int, FirstName varchar(255), LastName varchar(255));
Create table Address (AddressId int, PersonId int, City varchar(255), State varchar(255));
Truncate table Person;
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen');
Truncate table Address;
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York');

select
  P.FirstName as FirstName,
  P.LastName as LastName,
  A.City as City,
  A.State as State
from Person P left join Address A on P.PersonId = A.PersonId;

select
  P.FirstName as FirstName,
  P.LastName as LastName,
  A.City as City,
  A.State as State
from Person P left join Address A USING (PersonId);