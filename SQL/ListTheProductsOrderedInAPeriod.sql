SELECT Products.product_name, T.unit
FROM Products JOIN (
    SELECT product_id, Sum(unit) as unit
    FROM Orders
    WHERE Date_format(order_date, "%Y-%m") = "2020-02"
    GROUP BY product_id
    HAVING Sum(unit) >= 100) AS T ON Products.product_id = T.product_id;