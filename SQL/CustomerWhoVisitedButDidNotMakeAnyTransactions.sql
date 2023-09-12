SELECT customer_id, Count(*) AS count_no_trans
FROM Visits LEFT JOIN Transactions USING(visit_id)
WHERE IsNull(transaction_id)
GROUP BY customer_id;