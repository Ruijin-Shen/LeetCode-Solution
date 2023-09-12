SELECT query_name, Round(Avg(rating / position), 2) AS quality, Round(Sum(IF(rating < 3, 1, 0)) / Count(*) * 100, 2) AS poor_query_percentage
FROM Queries
GROUP BY query_name