package requestDomain;

import dao.entities.Person;
import dao.entities.enums.AccountType;

public class AccountRequest {

    public AccountRequest(final String id, final String password, final Person person, final AccountType accountType) {
        this.id = id;
        this.password = password;
        this.person = person;
        this.accountType = accountType;
    }

    public String id;
    public String password;
    public Person person;
    public AccountType accountType;
}
