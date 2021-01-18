




DROP table If Exists seat;
Create table If Not Exists seat(id int, student varchar(255));
Truncate table seat;
insert into seat (id, student) values ('1', 'Abbot');
insert into seat (id, student) values ('2', 'Doris');
insert into seat (id, student) values ('3', 'Emerson');
insert into seat (id, student) values ('4', 'Green');
insert into seat (id, student) values ('5', 'Jeames');

select
  if(id < (select count(*) from seat),
     if(id mod 2=0, id-1, id+1),
     if(id mod 2=0, id-1, id)) as id, # odd and end
  student
from seat
order by id asc;

select
  s1.id,
  ifnull(s2.student, s1.student) as student
from seat s1 left join seat s2
  on ((s1.id % 2 = 1 and s1.id + 1 = s2.id) or (s1.id % 2 = 0 and s1.id - 1 = s2.id))
order by s1.id;

SELECT
    s1.id, COALESCE(s2.student, s1.student) AS student
FROM
    seat s1
        LEFT JOIN
    seat s2 ON ((s1.id + 1) ^ 1) - 1 = s2.id
ORDER BY s1.id;

select
  (case
    when id % 2 = 0 then id - 1
    when id % 2 = 1 then if(id=total, total, id + 1)
  end) as id, student
from
  seat,
  (select count(*) as total from seat) total_seat
ORDER BY id ASC;

