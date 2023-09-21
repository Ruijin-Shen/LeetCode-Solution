SELECT *
FROM Users
WHERE mail REGEXP '^[A-Za-z][0-9A-Za-z\\.\\-\\_]{0, }@leetcode\\.com$'