SELECT user_id, Round(SUM(IF(action = 'confirmed', 1, 0)) / Count(*), 2) AS confirmation_rate
FROM Signups LEFT JOIN Confirmations USING(user_id)
GROUP BY user_id;