package dao.entities;

import dao.entities.enums.AccountType;

public class Account {

    public String id;
    public String password;
    public Person person;
    public AccountType accountType;

    public Account(final String id, final String password, final Person person, final AccountType accountType) {
        this.id = id;
        this.password = password;
        this.person = person;
        this.accountType = accountType;
    }
}
