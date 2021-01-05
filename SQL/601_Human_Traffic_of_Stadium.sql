-- 题目要求用id, 不用date
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
      datediff(s2.date, s1.date) = 1
      and
      datediff(s3.date, s2.date) = 1
    )
    or
    (
      datediff(s1.date, s2.date) = 1
      and
      datediff(s3.date, s1.date) = 1
    )
    or
    (
      datediff(s2.date, s3.date) = 1
      and
      datediff(s1.date, s2.date) = 1
    )
  )
order by s1.id;
;



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
