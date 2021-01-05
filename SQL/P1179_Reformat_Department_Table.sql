--  how to insert new column: 1.join 2.aggregate function(group by sum, max)
-- add distinct id  will accelerate, not single id

select distinct id,
sum(case when month = "jan" then revenue else null end) as Jan_Revenue,
sum(case when month = "feb" then revenue else null end) as Feb_Revenue,
sum(case when month = "mar" then revenue else null end) as Mar_Revenue,
sum(case when month = "apr" then revenue else null end) as Apr_Revenue,
sum(case when month = "may" then revenue else null end) as May_Revenue,
sum(case when month = "jun" then revenue else null end) as Jun_Revenue,
sum(case when month = "jul" then revenue else null end) as Jul_Revenue,
sum(case when month = "aug" then revenue else null end) as Aug_Revenue,
sum(case when month = "sep" then revenue else null end) as Sep_Revenue,
sum(case when month = "oct" then revenue else null end) as Oct_Revenue,
sum(case when month = "nov" then revenue else null end) as Nov_Revenue,
sum(case when month = "dec" then revenue else null end) as Dec_Revenue
from Department
group by id
order by id;

select distinct id,
max(if(month = "jan", revenue, null)) as Jan_Revenue,
max(if(month = "feb", revenue, null)) as Feb_Revenue,
max(if(month = "mar", revenue, null)) as Mar_Revenue,
max(if(month = "apr", revenue, null)) as Apr_Revenue,
max(if(month = "may", revenue, null)) as May_Revenue,
max(if(month = "jun", revenue, null)) as Jun_Revenue,
max(if(month = "jul", revenue, null)) as Jul_Revenue,
max(if(month = "aug", revenue, null)) as Aug_Revenue,
max(if(month = "sep", revenue, null)) as Sep_Revenue,
max(if(month = "oct", revenue, null)) as Oct_Revenue,
max(if(month = "nov", revenue, null)) as Nov_Revenue,
max(if(month = "dec", revenue, null)) as Dec_Revenue
from Department
group by id
order by id;
