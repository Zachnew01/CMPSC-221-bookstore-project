package psu.edu.bookstore.bootstrap;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import psu.edu.bookstore.Model.Genre;
import psu.edu.bookstore.Repository.BookRepository;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final BookRepository bookRepository;

    public DatabaseLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("This Works");
        bookRepository.addBook(1,"Moby Dick",1503280780L,"Herman Melville","10/18/1851", Genre.Fantasy,25.95);
        bookRepository.addBook(2,"Little Women",9780553202754L,"Louisa May Alcott","5/1/1883", Genre.Classic,5.95);
        bookRepository.addBook(3,"The Lion, The Witch, and The Wardrobe",9780001831070L,"C. S. Lewis","1/1/1972", Genre.Fantasy,7.99);

    }
}
