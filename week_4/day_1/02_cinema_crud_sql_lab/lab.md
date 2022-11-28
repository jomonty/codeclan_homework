# SQL Lab

The Springfield Cinema is having a Marvel Movie Marathon! They have asked you to help maintain their database of movies with times and attendees.

## To access the database:

First, create a database called 'marvel'

```
# terminal
createdb marvel
```

Next, run the provided SQL script to populate your database:

```
# terminal
psql -d marvel -f marvel.sql
```

Use the supplied data as the source of data to answer the questions. Copy the SQL command you have used to get the answer, and paste it below the question, along with the result they gave.

## Questions

1.  Return ALL the data in the 'movies' table.
-- Q1
SELECT *
FROM movies;

2.  Return ONLY the name column from the 'people' table
-- Q2
SELECT name
FROM people;

3.  Oops! Someone spelled Krusty The Clown's name wrong! Change it to reflect the proper spelling (Crusty should be Krusty).
-- Q3
UPDATE people
SET name='Krusty the Clown'
WHERE name='Crusty the Clown';

4.  Return ONLY Homer Simpson's name from the 'people' table.
-- Q4
SELECT name
FROM people
WHERE name='Homer Simpson';

5.  The cinema is showing 'Batman Begins', but Batman is DC, not Marvel! Delete the entry from the 'movies' table.
-- Q5
DELETE FROM movies
WHERE title='Batman Begins';

6.  We forgot one of the main characters! Add Bart Simpson to the 'people' table
-- Q6
INSERT INTO people (name)
VALUES
('Bart Simpson');

7.  Eric Cartman has decided to hijack our movie evening, Remove him from the table of people.
-- Q7
DELETE FROM people
WHERE name='Eric Cartman';

8.  The cinema has just heard that they will be holding an exclusive midnight showing of 'Avengers: Infinity War'!! Create a new entry in the 'movies' table to reflect this.
-- Q8
INSERT INTO movies (title, year, show_time)
VALUES
('Avengers: Infinity War', '2018', '00:00');

9.  The cinema would like to make the Iron Man movies a triple billing. Find out the show time of "Iron Man 2" and set the show time of "Iron Man 3" to start two hours later.
-- Q9
UPDATE movies 
SET show_time = (SELECT (show_time::time + interval '2 hours')::VARCHAR(5) FROM movies WHERE title='Iron Man 2')
WHERE title='Iron Man 3'

## Extension

1.  Research how to delete multiple entries from your table in a single command.
DELETE FROM movies
WHERE title in ('','','')
