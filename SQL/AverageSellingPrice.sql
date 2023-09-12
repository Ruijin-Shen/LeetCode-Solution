SELECT UnitsSold.product_id, Round(Sum(units * price) / Sum(units), 2) AS average_price
FROM UnitsSold JOIN Prices ON UnitsSold.product_id = Prices.product_id AND purchase_date BETWEEN start_date AND end_date
GROUP BY UnitsSold.product_id;