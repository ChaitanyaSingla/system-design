package service.serviceInterface;

import dao.entities.enums.AccountType;
import requestDomain.AccountRequest;

public interface AccountServiceInterface {

    void addAccount(AccountRequest accountRequest);

    boolean isAccountValid(final String accountId, final AccountType accountType);

}
