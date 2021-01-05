SELECT
  e1.Name AS Employee
FROM
  Employee e1,
  Employee e2
WHERE
  e1.ManagerId IS NOT NULL
  AND e2.Id = e1.ManagerId
  AND e1.Salary > e2.Salary
;

SELECT
  e1.Name AS Employee
FROM
  Employee e1,
JOIN
  Employee e2
ON
  e2.Id = e1.ManagerId
  AND e1.Salary > e2.Salary
;

