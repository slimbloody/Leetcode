DROP table If Exists Employee;
DROP table If Exists Department;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Will', '70000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');
# sol1: union

SELECT
  d1.Name as Department,
  e1.Name as Employee,
  e1.Salary as Salary
FROM
  Employee e1,
LEFT JOIN
  Department d1
ON
  d1.Id = e1.DepartmentId
WHERE
  3 > (SELECT
        COUNT(DISTINCT e2.Salary)
      FROM
        Employee e2
      WHERE
        e2.Salary > e1.Salary
        AND e1.DepartmentId = e2.DepartmentId
  )
;


select d.Name Department, t.Name Employee, t.Salary
from (
select ib.DepartmentId, ib.Salary, ib.Name,
       case
           when ib.DepartmentId=@pname and ib.Salary!=@psal then @row:=@row+1
           when ib.DepartmentId=@pname and ib.Salary=@psal then @row:=@row
           else @row:=1
       end rownum,
       @pname := ib.DepartmentId,
       @psal := ib.Salary
  from employee ib, (select @row := 1, @pname:= 0, @psal :=0) row1
 order by ib.DepartmentId, ib.Salary desc
) t
join
Department d
on t.DepartmentId = d.Id
where t.rownum <= 3
order by d.Name, t.Salary desc;


select r.name as Department,
       Employee,
       Salary
from (
    select l.DepartmentId,
        l.name as Employee,
        l.Salary,
        (
            case
                when @did != (@did := l.DepartmentId) then @row := 1
                when @salary = l.salary then @row
                else @row := @row + 1
            end
        ) as rank,
        @salary := l.salary
    from Employee l, (select @row := 0, @did := -1, @salary := -1) init
    order by l.DepartmentId, l.Salary desc
) tmp
join Department r on tmp.DepartmentId = r.id
where tmp.rank <= 3;

select
  d.Name as Department,
  c.Name as Employee,
  c.Salary
from
(select
   a.Name
   , a.Salary
   , a.DepartmentId
   ,if(@depart = a.DepartmentId,@rank := @rank + (@sal <> a.Salary), @rank := 1)  as rank
  , @depart := a.DepartmentId as depart
  , @sal := a.Salary
from (
    select
    Id,
    Name,
    Salary,
    DepartmentId
    from Employee
    order by DepartmentId desc, Salary desc
) a, (select @rank := 1, @depart := -1, @sal := -1) foo) c left join Department d on c.DEpartmentId = d.Id
where c.rank < 4 and d.Id is not null;



select Department,Employee,Salary from
(select
	Department,
    Employee,
    Salary,
    @rn1:=if (@pk1=DepartmentId,if(@sal=salary,@rn1,@rn1:=@rn1+1),1) as rank,
    @pk1:=DepartmentId,
    @sal:=Salary
from(select d.Name as Department,
    e.Name as Employee,
    Salary,
    DepartmentID
from
	Department d
join
	Employee e
on
	d.Id=e.DepartmentId

order by
	DepartmentId,
    Salary desc) a
join
	(select @pk1:='',@rn1:=1, @sal:='') r
) b
where rank <=3
order by Department,Salary desc;


select d.Name as Department, e.Name as Employee, e.Salary
from
(
    select Id, `Name`, Salary, DepartmentId,
        (
            case
                when @prev_id = DepartmentId and @prev_salary != Salary then @row := @row + 1
                when @prev_id = DepartmentId and @prev_salary = Salary then @row := @row
                else @row := 1
            end
        ) as row_num,
        @prev_id := DepartmentId,
        @prev_salary := Salary
    from Employee, (select @row := 0, @prev_id := 0, @prev_salary := 0) v
    order by DepartmentId, Salary desc
) e join Department d on e.DepartmentId = d.Id
where e.row_num <= 3;

SELECT y.Name as Department,x.Name as Employee,x.Salary as Salary FROM (
SELECT @i:= case when @di = a.DepartmentId then if(@sl = a.Salary,@i,@i+1) else 1 end as idx,
    @di:= a.DepartmentId as di,
    @sl:= a.Salary as sl,
    a.DepartmentId,a.Salary, a.Name, a.Id
from Employee a,(select @i:=1,@di:='',@sl:='') b
order by a.DepartmentId ASC,a.Salary DESC
) x INNER JOIN Department y on x.DepartmentId = y.Id
WHERE x.idx < 4;

select r.name as Department,
       t.Employee,
       t.salary
from (
    select l.name as Employee,
           l.salary,
           l.DepartmentId,
           (@rank := case
               when @dept != l.DepartmentId then 1
               when @salary = l.salary then @rank
               else @rank + 1
           end) as rank,
           @dept := l.DepartmentId,
           @salary := l.salary
    from Employee l, (select @rank := 0, @salary := -1, @dept := -1) vars
    order by l.DepartmentId, l.salary desc
) t join Department r on t.DepartmentId = r.id
where t.rank <= 3;

select Department, Employee, Salary from (
select *,
      @num := if(@type = Department, if(@sal = Salary,@num,@num + 1), 1) as row_number,
      @type:= Department,
      @Sal := Salary
  from (select b.Name as Department, a.Name as Employee, Salary
               from Employee as a left join Department as b on a.DepartmentId=b.Id) as x,
  (select @num:=1, @type:='',@sal:=0) init
order by Department, Salary Desc
) as k
where Department is not NULL and row_number <= 3
