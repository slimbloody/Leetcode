drop table If Exists stadium;
Create table If Not Exists stadium (id int, visit_date DATE NULL, people int);
Truncate table stadium;
insert into stadium (id, visit_date, people) values ('1', '2017-01-01', '10');
insert into stadium (id, visit_date, people) values ('2', '2017-01-02', '109');
insert into stadium (id, visit_date, people) values ('3', '2017-01-03', '150');
insert into stadium (id, visit_date, people) values ('4', '2017-01-04', '99');
insert into stadium (id, visit_date, people) values ('5', '2017-01-05', '145');
insert into stadium (id, visit_date, people) values ('6', '2017-01-06', '1455');
insert into stadium (id, visit_date, people) values ('7', '2017-01-07', '199');
insert into stadium (id, visit_date, people) values ('8', '2017-01-09', '188');




select
*
from stadium s1
  join stadium s2 on s2.id - s1.id = 1
  join stadium s3 on s3.id - s2.id = 1
where (
  s1.people >= 100
  and s2.people >= 100
  and s3.people >= 100
);

select distinct
  s1.*
from
  stadium as s1,
  stadium as s2,
  stadium as s3
where
  s1.people >= 100
  and s2.people >= 100
  and s3.people >= 100
  and (
    (
      s2.id - s1.id = 1
      and s3.id - s2.id = 1
    )
    or
    (
      s1.id - s2.id = 1
      and s3.id - s1.id = 1
    )
    or
    (
      s2.id - s3.id = 1
      and s1.id - s2.id = 1
    )
  )
order by s1.id;
;
