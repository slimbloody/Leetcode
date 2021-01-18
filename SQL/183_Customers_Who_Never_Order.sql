drop table If Exists Customers;
drop table If Exists Orders;
Create table If Not Exists Customers (Id int, Name varchar(255));
Create table If Not Exists Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');

select c.Name as Customers
from Customers c left join Orders o on c.Id = o.CustomerId
where o.Id is null;

SELECT Name as Customers
FROM Customers
WHERE Customers.Id not in (
  SELECT CustomerId
  FROM Orders
);


