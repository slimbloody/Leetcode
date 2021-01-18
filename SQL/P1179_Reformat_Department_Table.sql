-- how to insert new column: 1.join 2.aggregate function(group by sum, max)
-- add distinct id  will accelerate, not single id

DROP table If Exists Department;
Create table If Not Exists Department (id int, revenue int, month varchar(5));
Truncate table Department;
insert into Department (id, revenue, month) values ('1', '8000', 'Jan');
insert into Department (id, revenue, month) values ('2', '9000', 'Jan');
insert into Department (id, revenue, month) values ('3', '10000', 'Feb');
insert into Department (id, revenue, month) values ('1', '7000', 'Feb');
insert into Department (id, revenue, month) values ('1', '6000', 'Mar');

select
  distinct(id) as id,
  sum(if(month = 'Jan', revenue, 0)) as Jan_Revenue,
  sum(if(month = 'Feb', revenue, 0)) as Feb_Revenue,
  sum(if(month = 'Mar', revenue, 0)) as Mar_Revenue,
  sum(if(month = 'Apr', revenue, 0)) as Apr_Revenue,
  sum(if(month = 'May', revenue, 0)) as May_Revenue,
  sum(if(month = 'Jun', revenue, 0)) as Jun_Revenue,
  sum(if(month = 'Jul', revenue, 0)) as Jul_Revenue,
  sum(if(month = 'Aug', revenue, 0)) as Aug_Revenue,
  sum(if(month = 'Sep', revenue, 0)) as Sep_Revenue,
  sum(if(month = 'Oct', revenue, 0)) as Oct_Revenue,
  sum(if(month = 'Nov', revenue, 0)) as Nov_Revenue,
  sum(if(month = 'Dec', revenue, 0)) as Dec_Revenue
from Department
group by id
order by id;
