package psu.edu.bookstore.Model;

import java.util.Date;

public class Book {
    private int bookID;
    private String title;
    private long isbn;
    private String author;
    private String publishDate;
    private Genre genre; // Horror, Classic, NonFiction, Romance, Drama, SciFi, Fantasy, Humor;
    private double price;

    public Book() {
        this.bookID = 0;
        this.title = "";
        this.isbn = 0;
        this.author = "";
        this.publishDate = "";
        this.genre = Genre.Classic;
        this.price = 0.0;
    }

    public Book(int bookID, String title, long isbn, String author, String publishDate, Genre genre, double price) {
        this.bookID = bookID;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publishDate = publishDate;
        this.genre = genre;
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}