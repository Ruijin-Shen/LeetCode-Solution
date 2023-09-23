SELECT employee_id, IF(Mod(employee_id, 2) = 1 AND name NOT REGEXP '^M', salary, 0) AS BONUS
FROM Employees
ORDER BY employee_id;