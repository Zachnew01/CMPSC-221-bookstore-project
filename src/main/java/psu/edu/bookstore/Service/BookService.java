package psu.edu.bookstore.Service;

import psu.edu.bookstore.Model.Book;
import psu.edu.bookstore.Model.Genre;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    String validateFormSubmit(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price);

    void addBook(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price);

    void deleteBook(int bookId);

    Book getBookById(int bookId);

    void editBook(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price);
}
