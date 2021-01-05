SELECT DISTINCT
  l1.Num AS ConsecutiveNums
FROM
  Logs as l1,
  Logs as l2,
  Logs as l3
WHERE
  l1.Id = l2.Id - 1
  AND L2.Id = l3.Id - 1
  AND l1.Num = l2.Num
  AND l2.Num = l3.Num
;


select distinct
  Num as ConsecutiveNums
from
(
  select
    Num,
    cast(if(Num = @num, @ct := @ct + 1, @ct := 1) as UNSIGNED) as ct,
    @num := Num
  from
    Logs,
    (select @ct :=1 , @num := 'x') as b
) f
where ct>=3;


select distinct
  Num as ConsecutiveNums
from
(
  select
    Num,
    @counter := if(@prev = Num, @counter + 1, 1) as cnt,
    @prev := Num
  from
    Logs y,
    (select @counter := 1, @prev := NULL) tmp
) counts
where cnt >= 3;


select distinct
  c.num as ConsecutiveNums
from (
  select
    num,
    if(@lastvalue=num, @rank:=@rank+1, @rank:=1) rank,
    @lastvalue:=num as lastvalue
    from
      Logs a,
      (select @lastvalue:=0, @rank:=0) b
) c
where rank = 3;


SELECT DISTINCT
  T1.Num ConsecutiveNums
FROM (
  SELECT
    Num,
    (@Row :=@Row + (@Prev <> @Prev:= Num)) Rank
FROM
  Logs,
  (SELECT @Row:=0, @Prev:=-1) AS Temp
GROUP BY Rank
HAVING COUNT(Rank) >=3) T1;



