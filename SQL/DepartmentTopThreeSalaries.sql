WITH employee_department AS
         (
             SELECT d.name AS Department,
                    salary AS Salary,
                    e.name AS Employee,
                    DENSE_RANK()OVER(PARTITION BY d.id ORDER BY salary DESC) AS rnk
             FROM Department d JOIN Employee e ON d.id = e.departmentId
         )
SELECT Department, Employee, Salary
FROM employee_department
WHERE rnk <= 3;

SELECT d.name AS 'Department',
       e1.name AS 'Employee',
       e1.salary AS 'Salary'
FROM Employee e1 JOIN Department d ON e1.departmentId = d.id
WHERE 3 > (SELECT COUNT(DISTINCT e2.salary)
           FROM Employee e2
           WHERE e2.salary > e1.salary AND e1.departmentId = e2.departmentId);