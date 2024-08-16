package service;

import dao.adapter.AccountPersistence;
import dao.daoInterface.AccountPersistenceInterface;
import dao.entities.Account;
import dao.entities.enums.AccountType;
import requestDomain.AccountRequest;
import service.serviceInterface.AccountServiceInterface;

import java.util.Objects;

public class AccountService implements AccountServiceInterface {

    private static final AccountService accountService = new AccountService(AccountPersistence.getInstance());

    private AccountService(final AccountPersistenceInterface accountPersistenceInterface) {
        this.accountPersistenceInterface = accountPersistenceInterface;
    }

    public static AccountService getInstance() {
        return accountService;
    }

    AccountPersistenceInterface accountPersistenceInterface;

    public void addAccount(final AccountRequest accountRequest) {
        System.out.println("Creating account");

        final Account account = new Account(accountRequest.id, accountRequest.password, accountRequest.person, accountRequest.accountType);
        accountPersistenceInterface.addAccount(account);

        System.out.println("Account created");
    }

    public boolean isAccountValid(final String accountId, final AccountType accountType) {
        System.out.println("Checking if account is of type: " + accountType);

        final Account account = accountPersistenceInterface.getAccount(accountId);
        final boolean isValidAccount = Objects.nonNull(account) && account.accountType == accountType;

        System.out.println("Account valid: " + isValidAccount);
        return isValidAccount;
    }
}
