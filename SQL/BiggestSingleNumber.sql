SELECT Max(U.num) AS num
FROM (SELECT num
      FROM MyNumbers
      GROUP BY num
      HAVING Count(num) = 1) AS U