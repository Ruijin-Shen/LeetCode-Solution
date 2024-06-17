SELECT
    (SELECT DISTINCT salary
     FROM Employee
     ORDER BY salary DESC
     LIMIT 1 OFFSET 1) AS SecondHighestSalary;


SELECT
    IFNULL(
            (SELECT DISTINCT salary
             FROM Employee
             ORDER BY salary DESC
             LIMIT 1 OFFSET 1),
            NULL) AS SecondHighestSalary;