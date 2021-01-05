SELECT Name as Customers
FROM Customers
WHERE Customers.Id not in (
  SELECT CustomerId
  FROM Orders
);


SELECT
  c.Name as Customers
FROM
  Customers as c
OUTER JOIN
  Orders as o
ON
  c.Id = o.CustomerId
WHERE
  CustomerId is null;


