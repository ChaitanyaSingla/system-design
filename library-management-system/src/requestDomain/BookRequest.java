package requestDomain;

public class BookRequest {

    public BookRequest(final String ISBN, final String title, final String subject, final String publisher, final String accountId) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.accountId = accountId;
    }

    public String ISBN;
    public String title;
    public String subject;
    public String publisher;
    public String accountId;
}
