SELECT class FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;


-- subquery
SELECT
    class
FROM
    (SELECT
        class, COUNT(DISTINCT student) AS num
    FROM
        courses
    GROUP BY class) AS temp_table
WHERE
    num >= 5
;
