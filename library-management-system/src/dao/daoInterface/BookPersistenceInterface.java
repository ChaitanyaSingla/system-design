package dao.daoInterface;

import dao.entities.Book;

public interface BookPersistenceInterface {

    void addBook(final Book book);

    void issueBook(final String ISBN);

    void returnBook(final String ISBN);

}
