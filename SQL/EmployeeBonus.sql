SELECT name, bonus
FROM Employee LEFT JOIN Bonus on Employee.empId = Bonus.empId
WHERE ISNULL(bonus) OR bonus < 1000;