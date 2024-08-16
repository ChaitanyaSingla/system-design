package service;

import dao.adapter.BookPersistence;
import dao.adapter.CatalogPersistence;
import dao.daoInterface.BookPersistenceInterface;
import dao.daoInterface.CatalogPersistenceInterface;
import dao.entities.Book;
import dao.entities.enums.BookStatus;
import requestDomain.IssueBookRequest;
import service.serviceInterface.BookManagementServiceInterface;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookManagementService implements BookManagementServiceInterface {

    private static final BookManagementService bookManagementService = new BookManagementService(BookPersistence.getInstance(), CatalogPersistence.getInstance());

    public static BookManagementService getInstance() {
        return bookManagementService;
    }

    public BookManagementService(final BookPersistenceInterface bookPersistenceInterface, final CatalogPersistenceInterface catalogPersistenceInterface) {
        this.bookPersistenceInterface = bookPersistenceInterface;
        this.catalogPersistenceInterface = catalogPersistenceInterface;
    }

    BookPersistenceInterface bookPersistenceInterface;
    CatalogPersistenceInterface catalogPersistenceInterface;

    public void issueBook(final IssueBookRequest issueBookRequest) {
        System.out.println("Book issue request for ISBN: " + issueBookRequest.ISBN);
        final List<Book> bookByISBN = catalogPersistenceInterface.getBooksByISBN(issueBookRequest.ISBN);
        if (bookByISBN.size() > 0 && bookByISBN.get(0).bookStatus.equals(BookStatus.AVAILABLE)) {
            System.out.println("Issuing book");
            bookPersistenceInterface.issueBook(issueBookRequest.ISBN);
            System.out.println("Book Issued");
        } else {
            System.out.println("Book is not available to issue");
        }
    }

    public void returnBook(final String ISBN) {
        System.out.println("Book return request for ISBN: " + ISBN);
        final List<Book> bookByISBN = catalogPersistenceInterface.getBooksByISBN(ISBN);
        if (bookByISBN.size() > 0 && bookByISBN.get(0).bookStatus.equals(BookStatus.ISSUED)) {
            final Date issueDate = bookByISBN.get(0).issueDate;

            // Create a Calendar instance and set the issueDate
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(issueDate);

            // Add 7 days to the issueDate
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            final Date issueDatePlus7Days = calendar.getTime();

            final Date currentDate = new Date();
            if (currentDate.after(issueDatePlus7Days)) {
                System.out.println("Returning book after 7 days, so 10$ fine will be imposed");
            }

            System.out.println("Returning book");
            bookPersistenceInterface.returnBook(ISBN);
            System.out.println("Book Returned");
        } else {
            System.out.println("Not able to return book");
        }
    }

}
