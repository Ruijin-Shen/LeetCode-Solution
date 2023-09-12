SELECT Students.student_id, Students.student_name, Subjects.subject_name, count(Examinations.subject_name) AS attended_exams
FROM (Students JOIN Subjects) LEFT JOIN Examinations USING(student_id, subject_name)
GROUP BY Students.student_id, Subjects.subject_name
ORDER BY student_id, subject_name;