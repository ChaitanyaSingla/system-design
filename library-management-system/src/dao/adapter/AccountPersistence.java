package dao.adapter;

import dao.daoInterface.AccountPersistenceInterface;
import dao.entities.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountPersistence implements AccountPersistenceInterface {

    private static final AccountPersistence accountPersistence = new AccountPersistence();

    public static AccountPersistence getInstance() {
        return accountPersistence;
    }

    List<Account> accountList = new ArrayList<>();
    Map<String, Account> accountIdAndAccountMap = new HashMap<>();

    public void addAccount(final Account account) {
        accountIdAndAccountMap.put(account.id, account);
        accountList.add(account);
    }

    public Account getAccount(final String accountId) {
        return accountIdAndAccountMap.get(accountId);
    }

}
