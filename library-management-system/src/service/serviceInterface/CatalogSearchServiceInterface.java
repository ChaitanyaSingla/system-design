package service.serviceInterface;

import dao.entities.Book;

import java.util.List;

public interface CatalogSearchServiceInterface {

    List<Book> getBookByISBN(String ISBN);

    List<Book> getBookByTitle(String title);

    List<Book> getBookBySubject(String subject);

    List<Book> getBookByPublisher(String publisher);

}
