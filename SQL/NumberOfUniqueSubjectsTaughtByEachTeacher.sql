SELECT teacher_id, Count(DISTINCT subject_id) AS cnt
FROM Teacher
Group By teacher_id;