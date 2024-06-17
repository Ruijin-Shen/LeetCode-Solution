SELECT name AS 'Customers'
FROM Customers
WHERE Customers.id NOT IN (SELECT DISTINCT customerId FROM ORDERS);

SELECT name as Customers
FROM Customers LEFT JOIN Orders ON Customers.id = Orders.customerId
WHERE Orders.id IS NULL;