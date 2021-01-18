DROP table if exists Employee;
Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');

select
  (select DISTINCT Salary
   from Employee
   order by Salary desc
   limit 1 offset 1)
    as SecondHighestSalary;

select
  IFNULL(
  (select MAX(e2.Salary)
   from Employee e1 join Employee e2 on e1.Salary > e2.Salary
   group by e1.Salary
   order by e1.Salary desc
   limit 1 offset 0), null
    ) as SecondHighestSalary;

SELECT max(Salary) as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT max(Salary) FROM Employee)


