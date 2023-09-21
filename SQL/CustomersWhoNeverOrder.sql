SELECT name as 'Customers'
FROM Customers
WHERE Customers.id NOT IN (SELECT DISTINCT customerId FROM ORDERS);