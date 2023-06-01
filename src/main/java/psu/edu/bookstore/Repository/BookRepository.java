package psu.edu.bookstore.Repository;

import psu.edu.bookstore.Model.Book;
import psu.edu.bookstore.Model.Genre;

import java.util.List;

public interface BookRepository {

    List<Book> getBooks();

    void addBook(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price);

    void deleteBook(int bookId);

    Book getBookById(int bookId);

}
