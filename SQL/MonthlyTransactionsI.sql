SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month, country,
       Count(*) AS trans_count, Sum(IF(state = 'approved', 1, 0)) AS approved_count,
       Sum(amount) AS trans_total_amount,
       Sum(amount * IF(state = 'approved', 1, 0)) AS approved_total_amount
FROM Transactions
GROUP BY month, country;