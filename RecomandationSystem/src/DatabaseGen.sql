CREATE TABLE users(
 username TEXT NOT NULL,
 password TEXT NOT NULL,

);
CREATE TABLE songs(
   song_name TEXT NOT NULL,
   singer TEXT NOT NULL,
   genre TEXT NOT NULL,
   likes INTEGER NOT NULL,
   PRIMARY KEY(song_name)
);

CREATE TABLE books(
    book_name TEXT NOT NULL,
    author TEXT NOT NULL,
    genre TEXT NOT NULL,
    specie TEXT NOT NULL,
    likes INTEGER NOT NULL,
    PRIMARY KEY (book_name)
);
CREATE TABLE movies(
    movie_name TEXT NOT NULL,
    genre TEXT NOT NULL,
    likes INTEGER NOT NULL,
    PRIMARY KEY (movie_name)
);



