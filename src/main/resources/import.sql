INSERT INTO Author (name) VALUES ('George Orwell');
INSERT INTO Author (name) VALUES ('J.R.R. Tolkien');
INSERT INTO Author (name) VALUES ('Machado de Assis');

INSERT INTO Book (title, author, isbn, publication_date, publisher, number_of_pages, synopsis, writer_id) VALUES ( '1984','George Orwell', '978-0451524935', '1949-06-08', 'Secker & Warburg', 328, 'Um romance distópico sobre um futuro onde o governo controla todos os aspectos da vida das pessoas.',1);

INSERT INTO Book (title, author, isbn, publication_date, publisher, number_of_pages, synopsis, writer_id) VALUES ( '1984','George Orwell', '978-0451524935', '1949-06-08', 'Secker & Warburg', 328, 'Um romance distópico sobre um futuro onde o governo controla todos os aspectos da vida das pessoas.',2);

INSERT INTO Book (title, author, isbn, publication_date, publisher, number_of_pages, synopsis, writer_id) VALUES ( '1984','George Orwell', '978-0451524935', '1949-06-08', 'Secker & Warburg', 328, 'Um romance distópico sobre um futuro onde o governo controla todos os aspectos da vida das pessoas.',3);


INSERT INTO Genre (name) VALUES ('Ficção'), ('Romance'),('Fantasia');


INSERT INTO book_genre (book_id, genre_id) VALUES(1, 3);
INSERT INTO book_genre (book_id, genre_id) VALUES(2, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES(3, 1);

INSERT INTO Users (name, street, number, city, state) VALUES('Diego', 'cross street', '17', 'Marlborough',
                                                             'Massachupetis');
