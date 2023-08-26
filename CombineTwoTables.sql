SELECT firstName, LastName, city, state
FROM Person FULL OUTER JOIN Address ON Person.personId = Address.personId;