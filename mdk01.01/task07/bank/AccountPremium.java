package org.example.bank;

public class AccountPremium extends Account {
    public AccountPremium(String fName, String sName, String otecName) {
        super(fName, sName, otecName, LevelAccount.PREMIUM, 0, 0.05);
    }
}