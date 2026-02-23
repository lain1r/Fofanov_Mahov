package org.example.bank;

public class AccountBase extends Account {
    public AccountBase(String fName, String sName, String otecName) {
        super(fName, sName, otecName, LevelAccount.BASE, 100, 0.01);
    }
}