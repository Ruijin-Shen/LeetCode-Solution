SELECT T.id
FROM Weather as T join Weather as P ON DATEDIFF(T.recordDate, P.recordDate) = 1 AND T.temperature > P.temperature;


SELECT T.id
FROM Weather as T, Weather as P
WHERE T.temperature > P.temperature AND T.recordDate = (P.recordDate + Interval '1' DAY);

WITH PreviousWeatherData AS (
    SELECT id, recordDate, temperature,
           LAG(temperature, 1)OVER(ORDER BY recordDate) AS PreviousTemperature,
           LAG(recordDate, 1)OVER(ORDER BY recordDate) AS PreviousRecordDate
    FROM Weather)

SELECT id
FROM PreviousWeatherData
WHERE temperature > PreviousTemperature AND recordDate = (PreviousRecordDate + INTERVAL 1 DAY);