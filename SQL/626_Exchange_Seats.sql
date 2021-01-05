set @total = 1;
select @total:=count(*) from seat;
select id1 as id, stu2 as student
from
(select
  s1.id as id1,
  s1.student as stu1,
  s2.id as id2,
  s2.student as stu2
from
  seat s1
inner join
  seat s2
on
  s1.id =
  (case
    when s1.id % 2 = 0 then s2.id + 1
    when s1.id % 2 = 1 then if(s1.id = @total, s2.id, s2.id - 1)
  end)
) res
order by id asc;


select
  (case
    when id % 2 = 0 then id - 1
    when id % 2 = 1 then if(id=total, total, id + 1)
  end) as id, student
from
  seat,
  (select count(*) as total from seat) total_seat
ORDER BY id ASC;


SELECT
  s1.id, COALESCE(s2.student, s1.student) AS student
FROM
  seat s1
    LEFT JOIN
  seat s2 ON ((s1.id + 1) ^ 1) - 1 = s2.id
ORDER BY s1.id;



