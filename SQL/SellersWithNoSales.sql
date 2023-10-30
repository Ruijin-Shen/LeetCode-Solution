SELECT Seller.seller_name
FROM Seller LEFT JOIN Orders ON Seller.seller_id = Orders.seller_id and Year(sale_date) = 2020
GROUP By Seller.seller_id
HAVING Count(order_id) = 0
ORDER BY seller_name ASC;

/* select s.seller_name
from seller as s
where s.seller_id not in (select distinct seller_id from orders where year(sale_date) = 2020)
order by seller_name asc; */