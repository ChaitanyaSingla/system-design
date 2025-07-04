package model.actors;

import enums.AccountStatus;

public class Account {

    private String userName;

    private AccountStatus status;

    public Account(final String userName, final AccountStatus status) {
        this.userName = userName;
        this.status = status;
    }

    //Getter
    public String getUserName() {
        return userName;
    }

    public AccountStatus getStatus() {
        return status;
    }

}
