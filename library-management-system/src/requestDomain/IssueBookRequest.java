package requestDomain;

public class IssueBookRequest {

    public IssueBookRequest(final String ISBN, final String accountId) {
        this.ISBN = ISBN;
        this.accountId = accountId;
    }

    public String ISBN;
    public String accountId;
}
