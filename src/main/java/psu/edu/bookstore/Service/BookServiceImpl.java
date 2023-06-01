package psu.edu.bookstore.Service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import psu.edu.bookstore.Model.Book;
import psu.edu.bookstore.Model.Genre;
import psu.edu.bookstore.Repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public String validateFormSubmit(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price) {
        if (!StringUtils.hasText(title)) {
            return "Title is required";
        }
        if (!StringUtils.hasText(String.valueOf(isbn))) {
            return "ISBN is required";
        }
        if (!StringUtils.hasText(author)) {
            return "Author is required";
        }
        if (!StringUtils.hasText(publishDate)) {
            return "Publish Date is required";
        }
        if (!StringUtils.hasText(String.valueOf(genre))) {
            return "Genre is required";
        }
        if (!StringUtils.hasText(String.valueOf(price))) {
            return "Price is required";
        }
        return null;
    }

    @Override
    public void addBook(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price) {
        bookRepository.addBook(bookID, title, isbn, author, publishDate, genre, price);
    }

    @Override
    public void deleteBook(int bookId) {
        bookRepository.deleteBook(bookId);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public void editBook(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price) {
        var book = bookRepository.getBookById(bookID);
        if(book != null) {
            book.setTitle(title);
            book.setIsbn(isbn);
            book.setAuthor(author);
            book.setPublishDate(publishDate);
            book.setGenre(genre);
            book.setPrice(price);
        }
    }
}
