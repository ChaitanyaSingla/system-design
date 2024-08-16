package dao.entities;

import dao.entities.enums.BookStatus;

import java.util.Date;

public class Book {

    public String isbn;
    public String title;
    public String subject;
    public String publisher;
    public BookStatus bookStatus;
    public Date issueDate;

    public Book(final String isbn, final String title, final String subject, final String publisher,
                final BookStatus bookStatus, final Date issueDate) {
        this.isbn = isbn;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.bookStatus = bookStatus;
        this.issueDate = issueDate;
    }

}
