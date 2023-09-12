SELECT *
FROM Cinema
WHERE description <> 'boring' AND Mod(id, 2) = 1
ORDER BY rating DESC;