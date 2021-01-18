DROP table If Exists Employee;
DROP table If Exists Department;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Jim', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

DROP table If Exists Employee;
DROP table If Exists Department;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
insert into Employee (Id, Name, Salary, DepartmentId) values (1, 'Joe', 60000, 1);
insert into Employee (Id, Name, Salary, DepartmentId) values (4, 'Max', 60000, 2);
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'HR');

select
  temp.name as Department,
  emp.Name as Employee,
  emp.Salary as Salary
from Employee emp join
     (select
        max(Salary) as Salary,
        D.id as id,
        D.name as name
      from Employee e join Department D on e.DepartmentId = D.id
      group by D.Id, D.id, D.name) temp
     on emp.Salary = temp.Salary and emp.DepartmentId = temp.id
order by temp.name;

select
  d.Name as Department,
  e.Name as Employee,
  e.Salary as Salary
from
  Employee e join Department d on e.DepartmentId = d.Id
where
    (e.DepartmentId, e.Salary) in
    (select
       DepartmentId,
       max(Salary) as Salary
     from Employee
     group by DepartmentId)
order by e.Name;

