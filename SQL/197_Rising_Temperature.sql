select w1.Id as Id
from Weather w1, Weather w2
where datediff(w1.RecordDate, w2.RecordDate) = 1 and w1.Temperature > w2.Temperature;



select Id from Weather
where;


SELECT Id From
    (
        SELECT
            w.Id,
            (@higher := IF(w.Temperature>@temp AND DATEDIFF(w.RecordDate, @expectday)=1, 1, 0)) AS h,
            (@temp := w.Temperature) AS t,
            (@expectday := w.RecordDate) AS e
        FROM
            (SELECT @temp := 999999, @higher := 0, @expectday := "1000-01-01") AS init,
            (SELECT * FROM Weather ORDER BY RecordDate) AS w
    ) AS TempEX
WHERE h = 1


select c.Id from
(
    select a.Id as Id,@lastdate,DATEDIFF(a.RecordDate,@lastdate) as ddiff, if(@temp is not NULL, if(( a.Temperature-@temp) > 0,'yes','no') , 'no' ) as t, (@temp :=a.Temperature) as aaa, (@lastdate :=a.RecordDate) as abb from Weather a, (select @temp:=NULL) b, (select @lastdate:=NULL) d order by RecordDate asc
) c
where c.t = 'yes' and c.ddiff=1 ;


SELECT Id FROM (
    SELECT CASE
        WHEN Temperature > @prevtemp AND DATEDIFF(RecordDate, @prevdate) = 1 THEN Id ELSE NULL END AS Id,
        @prevtemp:=Temperature, @prevdate:=RecordDate
    FROM Weather, (SELECT @prevtemp:=NULL, @prevdate:=NULL) AS A ORDER BY RecordDate ASC
) AS D WHERE Id IS NOT NULL


SELECT R.Id FROM (
    SELECT
        IF(
            RecordDate = ADDDATE(@preDate, INTERVAL 1 DAY)
                AND Temperature > @preTemp,
            Id,
            NULL) AS Id,
        @preDate := RecordDate,
        @preTemp:= Temperature
    FROM Weather, (SELECT @preDate := NULL, @preTemp := NULL) INIT
    ORDER BY RecordDate
) R
WHERE R.Id IS NOT NULL


select r.id
  from (
        select a.id,a.recorddate,a.temperature,
               case when @t<a.temperature and @date=date_add(a.recorddate,interval -1 day) then 1 else 0 end as flag,
               @t:=a.temperature,
               @date:=a.recorddate
          from
            (
            select id,recorddate,temperature
              from Weather
             order by recorddate
             )a,
             (select @t:=null,@date:=null)b
        )r
  where r.flag=1
