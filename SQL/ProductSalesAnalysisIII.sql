SELECT Sales.product_id, first_year, quantity, price
FROM Sales JOIN
    (SELECT product_id, Min(year) AS first_year
     FROM Sales
     GROUP BY product_id) AS Y
     ON Sales.product_id = Y.product_id AND Sales.year = Y.first_year