SELECT student_id, course_id, grade
FROM
    (SELECT *, Row_number() Over(PARTITION BY student_id ORDER BY grade DESC, course_id ASC) AS rk
     FROM Enrollments) AS T
WHERE rk = 1
ORDER BY student_id ASC;