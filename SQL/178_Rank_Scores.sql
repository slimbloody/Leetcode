Drop table if exists Scores;
Create table If Not Exists Scores (Id int, Score DECIMAL(3,2));
Truncate table Scores;
insert into Scores (Id, Score) values ('1', '3.5');
insert into Scores (Id, Score) values ('2', '3.65');
insert into Scores (Id, Score) values ('3', '4.0');
insert into Scores (Id, Score) values ('4', '3.85');
insert into Scores (Id, Score) values ('5', '4.0');
insert into Scores (Id, Score) values ('6', '3.65');

select
  score1 as Score,
  count(distinct(score2)) as `Rank`
from
  (select
     s1.id as id,
     s1.Score as score1,
     s2.Score as score2
   from Scores s1 left join Scores s2 on s1.Score <= s2.Score
   group by s1.id, s1.Score, s2.Score) temp
group by id, score1
order by `Rank`;

SELECT
  Scores.Score as Score,
  @`rank`:=@`rank`+ (@prev != (@prev := Scores.Score)) `Rank`
FROM
  Scores,
  (SELECT @`rank` := 0, @`prev` := -1) init
ORDER BY Score desc;

SELECT
	Score,
	(
    SELECT count(DISTINCT(Score))
	  FROM
		  Scores
	  WHERE
		  Score >= s1.Score
	) AS Rank
FROM
	Scores AS s1
ORDER BY
	Score DESC;



