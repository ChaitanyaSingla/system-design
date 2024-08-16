package dao.daoInterface;

import dao.entities.Book;

import java.util.List;

public interface CatalogPersistenceInterface {

    List<Book> getBooksByISBN(final String ISBN);

    List<Book> getBooksByTitle(final String title);

    List<Book> getBooksBySubject(final String subject);

    List<Book> getBooksByPublisher(final String publisher);

}
