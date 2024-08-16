package dao.adapter;

import dao.daoInterface.CatalogPersistenceInterface;
import dao.entities.Book;

import java.util.List;

public class CatalogPersistence implements CatalogPersistenceInterface {

    private static final CatalogPersistence catalogPersistence = new CatalogPersistence();

    public static CatalogPersistence getInstance() {
        return catalogPersistence;
    }

    public List<Book> getBooksByISBN(final String ISBN) {
        return BookPersistence.getInstance().bookByISBN.get(ISBN);
    }

    public List<Book> getBooksByTitle(final String title) {
        return BookPersistence.getInstance().bookByTitle.get(title);
    }

    public List<Book> getBooksBySubject(final String subject) {
        return BookPersistence.getInstance().bookBySubject.get(subject);
    }

    public List<Book> getBooksByPublisher(final String publisher) {
        return BookPersistence.getInstance().bookByPublisher.get(publisher);
    }

}
