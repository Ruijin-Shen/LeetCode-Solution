SELECT person_name
FROM (SELECT person_name, Sum(weight) OVER(ORDER BY turn) AS total_weight, LEAD(weight, 1, 1000) OVER(ORDER BY turn) as LD
      FROM Queue) AS Temp
WHERE total_weight <= 1000 AND total_weight + LD > 1000;