package service;

import dao.adapter.BookPersistence;
import dao.adapter.CatalogPersistence;
import dao.daoInterface.BookPersistenceInterface;
import dao.daoInterface.CatalogPersistenceInterface;
import dao.entities.Book;
import dao.entities.enums.BookStatus;
import requestDomain.BookRequest;
import service.serviceInterface.BookServiceInterface;

public class BookService implements BookServiceInterface {

    private static final BookService bookService = new BookService(BookPersistence.getInstance(), CatalogPersistence.getInstance());

    private BookService(final BookPersistenceInterface bookPersistenceInterface, final CatalogPersistenceInterface catalogPersistenceInterface) {
        this.bookPersistenceInterface = bookPersistenceInterface;
        this.catalogPersistenceInterface = catalogPersistenceInterface;
    }

    public static BookService getInstance() {
        return bookService;
    }

    BookPersistenceInterface bookPersistenceInterface;
    CatalogPersistenceInterface catalogPersistenceInterface;

    public void addBook(final BookRequest bookRequest) {
        System.out.println("Adding book");

        final Book book = new Book(bookRequest.ISBN, bookRequest.title, bookRequest.subject,
                bookRequest.publisher, BookStatus.AVAILABLE, null);
        bookPersistenceInterface.addBook(book);

        System.out.println("Book added");
    }

}
