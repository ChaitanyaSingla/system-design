package service;

import dao.adapter.CatalogPersistence;
import dao.daoInterface.CatalogPersistenceInterface;
import dao.entities.Book;
import service.serviceInterface.CatalogSearchServiceInterface;

import java.util.List;

public class CatalogSearchService implements CatalogSearchServiceInterface {

    private static final CatalogSearchService catalogSearchService = new CatalogSearchService(CatalogPersistence.getInstance());

    private CatalogSearchService(final CatalogPersistenceInterface catalogPersistenceInterface) {
        this.catalogPersistenceInterface = catalogPersistenceInterface;
    }

    public static CatalogSearchService getInstance() {
        return catalogSearchService;
    }

    CatalogPersistenceInterface catalogPersistenceInterface;

    public List<Book> getBookByISBN(final String ISBN) {
        System.out.println("Getting books by ISBN: " + ISBN);
        return catalogPersistenceInterface.getBooksByISBN(ISBN);
    }

    public List<Book> getBookByTitle(final String title) {
        System.out.println("Getting books by title: " + title);
        return catalogPersistenceInterface.getBooksByTitle(title);
    }

    public List<Book> getBookBySubject(final String subject) {
        System.out.println("Getting books by subject: " + subject);
        return catalogPersistenceInterface.getBooksBySubject(subject);
    }

    public List<Book> getBookByPublisher(final String publisher) {
        System.out.println("Getting books by publisher: " + publisher);
        return catalogPersistenceInterface.getBooksByPublisher(publisher);
    }

}
