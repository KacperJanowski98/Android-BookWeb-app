package pl.janowski.bookweb;

import java.util.Date;

public class Book {
    String title;
    String author;
    Date date;

    public Book(){ }

    public Book(String title, String author, Date date){
        this.title = title;
        this.author = author;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
