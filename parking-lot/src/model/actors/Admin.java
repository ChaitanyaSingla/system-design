package model.actors;

import enums.AccountStatus;

public class Admin extends Account {
    public Admin(final String userName, final AccountStatus status) {
        super(userName, status);
    }
}
