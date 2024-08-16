import dao.entities.Book;
import dao.entities.Person;
import dao.entities.enums.AccountType;
import requestDomain.AccountRequest;
import requestDomain.BookRequest;
import requestDomain.IssueBookRequest;
import service.AccountService;
import service.BookManagementService;
import service.BookService;
import service.CatalogSearchService;
import service.serviceInterface.AccountServiceInterface;
import service.serviceInterface.BookManagementServiceInterface;
import service.serviceInterface.BookServiceInterface;
import service.serviceInterface.CatalogSearchServiceInterface;

import java.util.List;

public class LibraryManagementSystem {

    private final BookServiceInterface bookServiceInterface;
    private final CatalogSearchServiceInterface catalogSearchServiceInterface;
    private final AccountServiceInterface accountServiceInterface;
    private final BookManagementServiceInterface bookManagementServiceInterface;

    public LibraryManagementSystem(final BookServiceInterface bookServiceInterface,
                                   final CatalogSearchServiceInterface catalogSearchServiceInterface,
                                   final AccountServiceInterface accountServiceInterface,
                                   final BookManagementServiceInterface bookManagementServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
        this.catalogSearchServiceInterface = catalogSearchServiceInterface;
        this.accountServiceInterface = accountServiceInterface;
        this.bookManagementServiceInterface = bookManagementServiceInterface;
    }

    public void addBook(final BookRequest bookRequest) {
        final boolean isAccountValid = accountServiceInterface.isAccountValid(bookRequest.accountId, AccountType.LIBRARIAN);
        if (isAccountValid) {
            bookServiceInterface.addBook(bookRequest);
        }
    }

    public void getBookByTitle(final String title) {
        final List<Book> books = catalogSearchServiceInterface.getBookByTitle(title);
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ": " + books.get(i).title);
        }
    }

    public void getBookBySubject(final String subject) {
        final List<Book> books = catalogSearchServiceInterface.getBookBySubject(subject);
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ": " + books.get(i).title);
        }
    }

    public void addAccount(final AccountRequest accountRequest) {
        accountServiceInterface.addAccount(accountRequest);
    }

    public void issueBook(final IssueBookRequest issueBookRequest) {
        final boolean isAccountValid = accountServiceInterface.isAccountValid(issueBookRequest.accountId, AccountType.MEMBER);
        if (isAccountValid) {
            bookManagementServiceInterface.issueBook(issueBookRequest);
        }
    }

    public void returnBook(final String accountId, final String ISBN) {
        final boolean isAccountValid = accountServiceInterface.isAccountValid(accountId, AccountType.MEMBER);
        if (isAccountValid) {
            bookManagementServiceInterface.returnBook(ISBN);
        }
    }

    public static void main(final String[] args) {
        final LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(
                BookService.getInstance(),
                CatalogSearchService.getInstance(),
                AccountService.getInstance(),
                BookManagementService.getInstance()
        );

        //Add librarian account
        final AccountRequest accountRequest1 = new AccountRequest(
                "1",
                "1234",
                new Person("Anna", "anna@gmail.com", "9999999999", "Anna 123 Street"),
                AccountType.LIBRARIAN);
        libraryManagementSystem.addAccount(accountRequest1);

        System.out.println("------------------------------------------");

        //Add member account
        final AccountRequest accountRequest2 = new AccountRequest(
                "2",
                "1234",
                new Person("Gary", "gary@gmail.com", "9999999999", "Gary 123 Street"),
                AccountType.MEMBER);
        libraryManagementSystem.addAccount(accountRequest2);

        System.out.println("------------------------------------------");

        //Add book in the catalog
        final BookRequest bookRequest1 = new BookRequest(
                "001", "Harry Potter", "Fiction", "JK Rowling", "1");
        libraryManagementSystem.addBook(bookRequest1);

        System.out.println("------------------------------------------");

        //Add book in the catalog
        final BookRequest bookRequest2 = new BookRequest(
                "002", "Game of thrones", "Fiction", "JK Rowling", "1");
        libraryManagementSystem.addBook(bookRequest2);

        System.out.println("------------------------------------------");

        //Get book from catalog using title
        libraryManagementSystem.getBookByTitle("Harry Potter");

        System.out.println("------------------------------------------");

        //Get book from catalog using subject
        libraryManagementSystem.getBookBySubject("Fiction");

        System.out.println("------------------------------------------");

        //Issue book
        final IssueBookRequest issueBookRequest = new IssueBookRequest("001", "2");
        libraryManagementSystem.issueBook(issueBookRequest);

        System.out.println("------------------------------------------");

        //Return book
        libraryManagementSystem.returnBook("2", "001");

        System.out.println("------------------------------------------");
    }

}
