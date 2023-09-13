SELECT DISTINCT num AS ConsecutiveNums
FROM
    (
        SELECT num, LEAD(num, 1) OVER() AS LD, LAG(num, 1) OVER() AS LG
        FROM Logs
    ) AS T
WHERE LD = num AND LG = num