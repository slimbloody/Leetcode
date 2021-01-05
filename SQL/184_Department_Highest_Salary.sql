select
Department,
Employee,
Salary
from
(select
    Employee.Name as Employee,
    Employee.Salary as Salary,
    Department.Name as Department
from
    Employee
join
    Department
where
    Employee.DepartmentId = Department.Id) as jointable
group by
Department
having
Salary = max(Salary);

