package service.serviceInterface;

import requestDomain.IssueBookRequest;

public interface BookManagementServiceInterface {

    void issueBook(final IssueBookRequest issueBookRequest);

    void returnBook(final String ISBN);

}
