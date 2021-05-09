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
-----populare tabela SONGS ----------
INSERT into songs values ('Angels','Robbie Williams','pop music',0);
INSERT into songs values ('Back to black', 'Amy Winehouse','blues',0);
INSERT into songs values ('Dancing with your ghost', 'Sasha Sloan','pop music',0);
INSERT into songs values ('No habrá nadie en el mundo', 'Buika','latino',0);
INSERT into songs values ('Bailando', 'Enrique Iglesias','dance',0);
INSERT into songs values ('Ciao,ciao', 'Maria Nazionale','pop music',0);
INSERT into songs values ('Shape of My Heart', 'Sting','pop rock',0);
INSERT into songs values ('Callin U', 'Outlandish','pop music',0);
INSERT into songs values ('Starboy', ' The Weeknd','R&B',0);
INSERT into songs values ('Halo', 'Beyoncé','pop music',0);
INSERT into songs values ('Je taime', 'Lara Fabian','electro',0);
INSERT into songs values ('Dernière Danse', 'Indila','pop music',0);
INSERT into songs values ('I Want to Break Free', 'Queen','hard rock',0);
INSERT into songs values ('Yesterday', 'The Beatles','rock',0);
INSERT into songs values ('Gangsta Paradise', 'Coolio','rap',0);
INSERT into songs values ('Vivo per lei', 'Andrea Bocelli','opera',0);
INSERT into songs values ('Vals', 'Smiley','pop music',0);
INSERT into songs values ('Sugar', 'Maroon 5','pop rock',0);
INSERT into songs values ('Hotel California', 'Eagles','blues',0);
INSERT into songs values ('Earth song', ' Michael Jackson','pop music',0);


----------- populare taebla BOOKS ------------

INSERT into books values ('To Kill a Mockingbird','Harper Lee','drama','roman',0);
INSERT into books values ('Anna Karenina','Lev Tolstoy','realism','novel',0);
INSERT into books values ('Wuthering Heights','Emily Bronte','realism','novel',0);
INSERT into books values ('The Great Gatsby','F. Scott Fitzgerald','tragedy','novel',0);
INSERT into books values ('The Prince and the Pauper','Mark Twain','fictional','novel',0);
INSERT into books values ('The Idiot','Fyodor Dostoevsky','realism','novel',0);
INSERT into books values ('Harry Potter','J.K. Rowling','fictional','novel',0);
INSERT into books values ('Jane Eyre','Charlotte Brontë','romantice','novel',0);
INSERT into books values ('Inferno','Dan Brown','consipracy fiction','novel',0);
INSERT into books values ('The Lost Symbol','Dan Brown','consipracy fiction','novel',0);
INSERT into books values ('The Lady of the Camellias','Alexandre Dumas fils','romantice','novel',0);
INSERT into books values ('Romeo and Juliet','William Shakespeare','tragedy','play',0);
INSERT into books values ('The Three Musketeers','Alexandre Dumas','adventure','novel',0);
INSERT into books values ('The Lord of the Rings','J.R.R. Tolkien','fantasy','novel',0);
INSERT into books values ('The Book Thief','Markus Zusak','drama','novel',0);
INSERT into books values ('Animal Farm','George Orwell','fictional','novel',0);
INSERT into books values ('Think and Grow Rich','Napoleon Hill','self improvement','novel',0);
INSERT into books values ('A Brief History of Time',' Stephen Hawking','scientific','novel',0);
INSERT into books values ('Long Walk to Freedom','Nelson Mandela','historical','novel',0);


----------- populare tabela MOVIES ---------------

INSERT into movies values ('The Godfather ','Drama',0);
INSERT into movies values ('Casablanca','Romance',0);
INSERT into movies values ('Gone with the Wind','Romance',0);
INSERT into movies values ('The Sound of Music','Biography',0);
INSERT into movies values ('12 Angry Men','Crime',0);
INSERT into movies values ('Star Wars','SF',0);
INSERT into movies values ('Gladiator','Action',0);
INSERT into movies values ('Titanic','Drama',0);
INSERT into movies values ('Jurassic Park','Action',0);
INSERT into movies values ('The Exorcist','Horror',0);
INSERT into movies values ('Annie Hall','Comedy',0);
INSERT into movies values ('Toy Story','Comedy',0);
INSERT into movies values ('The Terminator','Action',0);
INSERT into movies values ('A walk to remember','Romance',0);
INSERT into movies values ('Notebook','Romance',0);
INSERT into movies values ('The Wolf of Wall Street','Biography',0);
INSERT into movies values ('The Hangover','Comedy',0);
INSERT into movies values ('Annabelle','Horror',0);
INSERT into movies values ('The Matrix','SF',0);
INSERT into movies values ('Captain America','SF',0);


