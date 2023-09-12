SELECT contest_id, Round(Count(user_id) / (SELECT Count(*) FROM Users) * 100, 2) AS percentage
FROM Register
Group By contest_id
ORDER BY percentage DESC, contest_id ASC;