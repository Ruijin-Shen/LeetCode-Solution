/* (SELECT employee_id, department_id
FROM Employee
GROUP BY employee_id
HAVING Count(*) = 1)

Union

(
SELECT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y'
);
*/

SELECT employee_id, department_id
FROM
    (SELECT *, Count(employee_id) OVER(PARTITION BY employee_id) AS EmployeeCount
     FROM Employee) AS EmployeePartition
WHERE EmployeeCount = 1 OR primary_flag = 'Y';