DROP table If Exists Weather;
Create table If Not Exists Weather (Id int, RecordDate date, Temperature int);
Truncate table Weather;
insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30');

select
  w2.id as id
from
  Weather w1, Weather w2
where
  datediff(w2.RecordDate, w1.RecordDate) = 1
  and w2.Temperature > w1.Temperature;
