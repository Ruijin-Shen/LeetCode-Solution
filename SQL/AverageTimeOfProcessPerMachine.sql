SELECT S.machine_id, Round(Avg(E.timestamp - S.timestamp), 3) as processing_time
FROM Activity AS S join Activity AS E ON S.process_id = E.process_id AND S.machine_id = E.machine_id AND S.activity_type = 'start' AND E.activity_type = 'end'
GROUP BY S.machine_id