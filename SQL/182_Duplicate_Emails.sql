SELECT DISTINCT(p1.Email) as Email
FROM Person as p1
JOIN Person as p2
ON p1.Email = p2.Email AND
p1.Id != P2.Id;

select Email from Person
group by Email
having count(Email) > 1;
