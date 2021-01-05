SELECT FirstName, LastName, City, State
FROM Person
JOIN Address
ON Person.PersonId = Address.PersonId;


