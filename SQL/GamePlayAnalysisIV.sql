SELECT Round(Count(Activity.player_id) / (SELECT Count(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity Join (
    SELECT player_id, Min(event_date) AS first_date
    FROM Activity
    GROUP BY player_id) AS F
    On Activity.player_id = F.player_id AND DATEDIFF(Activity.event_date, F.first_date) = 1;

SELECT ROUND(COUNT(a2.player_id) / COUNT(T.player_id), 2) AS fraction
FROM (
         SELECT player_id, MIN(event_date) AS first
         FROM Activity a1
         GROUP BY player_id) AS T LEFT JOIN Activity a2 ON T.player_id = a2.player_id AND T.first = (a2.event_date - INTERVAL 1 DAY);

SELECT ROUND(COUNT(a1.player_id) / (SELECT COUNT(DISTINCT a3.player_id) FROM Activity a3), 2) AS fraction
FROM Activity a1
WHERE (a1.player_id, DATE_SUB(a1.event_date, INTERVAL 1 DAY)) IN (
    SELECT a2.player_id, MIN(a2.event_date)
    FROM Activity a2
    GROUP BY a2.player_id);