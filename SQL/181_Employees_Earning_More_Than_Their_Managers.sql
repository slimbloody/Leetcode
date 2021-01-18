DROP table If Exists Employee;
Create table If Not Exists Employee (`Id` int, Name varchar(255), Salary int, ManagerId int);
Truncate table Employee;
insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', null);
insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', null);

select e1.Name as Employee
from Employee e1 join Employee e2 on e1.ManagerId = e2.Id
where e1.Salary > e2.Salary;

SELECT e1.Name AS Employee
FROM
  Employee e1,
  Employee e2
WHERE
  e1.ManagerId IS NOT NULL
  AND e2.Id = e1.ManagerId
  AND e1.Salary > e2.Salary;
