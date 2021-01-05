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

SELECT
  Score,
  @rank := @rank + (@prev <> (@prev := Score)) AS Rank
FROM
  Scores,
  (SELECT @rank := 0, @prev := -1) init
ORDER BY Score DESC;

SELECT
  Score,
  CAST(Rank AS UNSIGNED) AS Rank
FROM
  (SELECT
    @Rank := IF(Score < @PreviousScore, @Rank + 1, @Rank) AS Rank,
    @PreviousScore := Score AS Score
  FROM
    Scores
  JOIN
    (SELECT
      @Rank := CAST(1 AS UNSIGNED)) R
    JOIN
      (SELECT @PreviousScore := CAST(0 AS UNSIGNED)) S
  ORDER BY Score DESC
  ) AS C


