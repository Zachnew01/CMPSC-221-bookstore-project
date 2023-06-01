package psu.edu.bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import psu.edu.bookstore.Model.Book;
import psu.edu.bookstore.Model.Genre;
import psu.edu.bookstore.Service.BookService;

import java.util.List;

@Controller
public class AdminController {

    private final BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/books/view")
    public String index(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "View";
    }

    @GetMapping(value = "/delete/{bookID}")
    public String deleteBook(Model model, @PathVariable int bookID) {
        bookService.deleteBook(bookID);
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList",bookList);
        return "View";
    }

    @GetMapping(value = "/edit/{bookID}")
    public String editBookPage(Model model, @PathVariable int bookID) {
        Book book = bookService.getBookById(bookID);
        // int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price
        model.addAttribute("bookID", book.getBookID());
        model.addAttribute("title", book.getTitle());
        model.addAttribute("isbn", book.getIsbn());
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("publishDate", book.getPublishDate());
        model.addAttribute("genre", String.valueOf(book.getGenre()));
        model.addAttribute("price", book.getPrice());
        return "Edit";
    }

    @PostMapping(value="edit-book")
    public String editBookSubmit(Model model, @RequestParam String bookID, String title, String isbn, String author, String publishDate, String genre, String price){
        String errors = bookService.validateFormSubmit(Integer.parseInt(bookID), title, Long.parseLong(isbn), author, publishDate, Genre.valueOf(genre), Double.parseDouble(price));
        if(errors != null) {
            model.addAttribute("errors",errors);
            model.addAttribute("bookID", bookID);
            model.addAttribute("title", title);
            model.addAttribute("isbn", isbn);
            model.addAttribute("author", author);
            model.addAttribute("publishDate", publishDate);
            model.addAttribute("genre", genre);
            model.addAttribute("price", price);
        }
        else {
            model.addAttribute("success", "Changes were saved");
            bookService.editBook(Integer.parseInt(bookID), title, Long.parseLong(isbn), author, publishDate, Genre.valueOf(genre), Double.parseDouble(price));
        }
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList",bookList);
        return "View";
    }

    @GetMapping("admin/books/add")
    public String addBook(Model model) {

        return "Add";
    }

    @PostMapping(value="add-book")
    public String addBookSubmit(Model model, @RequestParam String bookID, String title, String isbn, String author, String publishDate, String genre, String price){
        String errors = bookService.validateFormSubmit(Integer.parseInt(bookID), title, Long.parseLong(isbn), author, publishDate, Genre.valueOf(genre), Double.parseDouble(price));
        if(errors != null) {
            model.addAttribute("errors",errors);
            model.addAttribute("bookID", bookID);
            model.addAttribute("title", title);
            model.addAttribute("isbn", isbn);
            model.addAttribute("author", author);
            model.addAttribute("publishDate", publishDate);
            model.addAttribute("genre", genre);
            model.addAttribute("price", price);
        }
        else {
            model.addAttribute("success", "Changes were saved");
            bookService.addBook(Integer.parseInt(bookID), title, Long.parseLong(isbn), author, publishDate, Genre.valueOf(genre), Double.parseDouble(price));
        }
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList",bookList);
        return "View";
    }
}
