package psu.edu.bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import psu.edu.bookstore.Model.Book;
import psu.edu.bookstore.Service.BookService;

import java.util.List;
import java.util.Locale;

@Controller
public class IndexController {

    private final BookService bookService;

    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "Home";
    }

    @GetMapping(value = "/search")
    public String searched(Model model, @RequestParam String search) {
        List<Book> bookList = bookService.getBooks();
        //var filtered = bookList.stream().filter(b -> b.getTitle().toLowerCase().contains(search.toLowerCase(Locale.ROOT))).toList();
        var filtered = bookList.stream().filter(b -> b.getTitle().toLowerCase().contains(search.toLowerCase(Locale.ROOT)) || b.getAuthor().toLowerCase().contains(search.toLowerCase(Locale.ROOT))).toList();
        model.addAttribute("bookList", filtered);
        return "Home";
    }

    @GetMapping("/contact-us")
    public String contact(Model model) {
        return "Contact-us";
    }

    @PostMapping(value = "/email")
    public String email(Model model) { //@RequestParam String exampleFormControlInput1, @RequestParam String exampleFormControlInput2, @RequestParam String exampleFormControlTextarea1
        model.addAttribute("success","The email was successfully sent.");
        return "Contact-us";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        return "Login";
    }

    @GetMapping(value = "/logout")
    public String logoutSuccess(Model model) {
        return "Logout";
    }
}
