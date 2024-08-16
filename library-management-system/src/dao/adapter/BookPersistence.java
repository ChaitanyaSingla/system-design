package dao.adapter;

import dao.daoInterface.BookPersistenceInterface;
import dao.entities.Book;
import dao.entities.enums.BookStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookPersistence implements BookPersistenceInterface {

    private static final BookPersistence bookPersistence = new BookPersistence();

    public static BookPersistence getInstance() {
        return bookPersistence;
    }

    List<Book> bookList = new ArrayList<>();
    Map<String, List<Book>> bookByISBN = new HashMap<>();
    Map<String, List<Book>> bookByTitle = new HashMap<>();
    Map<String, List<Book>> bookBySubject = new HashMap<>();
    Map<String, List<Book>> bookByPublisher = new HashMap<>();

    public void addBook(final Book book) {
        addBookToMap(bookByISBN, book.isbn, book);
        addBookToMap(bookByTitle, book.title, book);
        addBookToMap(bookBySubject, book.subject, book);
        addBookToMap(bookByPublisher, book.publisher, book);
        bookList.add(book);
    }

    public void issueBook(final String ISBN) {
        final Book book = bookByISBN.get(ISBN).get(0);
        book.bookStatus = BookStatus.ISSUED;
        book.issueDate = new Date();
    }

    public void returnBook(final String ISBN) {
        final Book book = bookByISBN.get(ISBN).get(0);
        book.bookStatus = BookStatus.AVAILABLE;
        book.issueDate = null;
    }

    private void addBookToMap(final Map<String, List<Book>> map, final String key, final Book book) {
        List<Book> books = map.get(key);
        if (books == null) {
            books = new ArrayList<>();
            map.put(key, books);
        }
        books.add(book);
    }

}
