package dao.daoInterface;

import dao.entities.Account;

public interface AccountPersistenceInterface {

    void addAccount(final Account account);

    Account getAccount(final String accountId);

}
