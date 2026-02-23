package org.example.bank;

public class AccountVip extends Account {
    public AccountVip(String fName, String sName, String otecName) {
        super(fName, sName, otecName, LevelAccount.VIP, 0, 0.05);
    }

    @Override
    public double calculateCashback(double count) {
        if (count >= 10000 && count < 100000) {
            return count * getCashback();
        } else if (count >= 100000) {
            return count * 0.1;
        }
        return count * 0.01;
    }
}