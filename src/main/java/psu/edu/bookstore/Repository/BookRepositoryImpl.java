package psu.edu.bookstore.Repository;

import org.springframework.stereotype.Repository;
import psu.edu.bookstore.Model.Book;
import psu.edu.bookstore.Model.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.google.common.collect.MoreCollectors;

@Repository
public class BookRepositoryImpl implements BookRepository{

    private List<Book> bookList;

    public BookRepositoryImpl() {
        this.bookList = new ArrayList<>();
    }

    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public void addBook(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price) {
        bookList.add(new Book(bookID, title, isbn, author, publishDate, genre, price));
    }

    @Override
    public void deleteBook(int bookId) {
        bookList = bookList.stream().filter(b -> !Objects.equals(b.getBookID(), bookId)).collect(Collectors.toList());
    }

    @Override
    public Book getBookById(int bookId) {
        return bookList.stream().filter(b -> Objects.equals(b.getBookID(), bookId)).collect(MoreCollectors.onlyElement());
    }
}
