SELECT tweet_id
FROM Tweets
WHERE Char_length(content) > 15;

/*
SELECT tweet_id
FROM Tweets
WHERE length(content) > 15;
 */