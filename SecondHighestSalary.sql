SELECT
    (SELECT DISTINCT id, salary
     FROM Employee
     ORDER BY salary DESC
     LIMIT 1 OFFSET 1) AS SecondHighestSalary;


SELECT
    IFNULL(
            (SELECT DISTINCT Salary
             FROM Employee
             ORDER BY Salary DESC
             LIMIT 1 OFFSET 1),
            NULL) AS SecondHighestSalary;