SELECT Round(Count(Activity.player_id) / (SELECT Count(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity Join (
    SELECT player_id, Min(event_date) AS first_date
    FROM Activity
    GROUP BY player_id) AS F
    On Activity.player_id = F.player_id AND DATEDIFF(Activity.event_date, F.first_date) = 1;