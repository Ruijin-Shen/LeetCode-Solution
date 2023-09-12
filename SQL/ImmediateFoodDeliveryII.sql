SELECT Round(Sum(IF(Delivery.order_date = Delivery.customer_pref_delivery_date, 1, 0)) / Count(*) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN
      (SELECT customer_id, Min(order_date) as first_date
       FROM Delivery
       GROUP BY customer_id);