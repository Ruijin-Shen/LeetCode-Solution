SELECT customer_id, customer_name
FROM Customers JOIN Orders USING(customer_id)
GROUP BY customer_id
HAVING SUM(product_name = 'A') > 0 AND SUM(product_name = 'B') > 0 AND SUM(product_name = 'C') = 0;