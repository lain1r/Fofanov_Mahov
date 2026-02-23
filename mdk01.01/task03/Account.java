package org.example.bank;

import java.util.Random;

public abstract class Account {
    private String fName;
    private String sName;
    private String otecName;
    private int renta;
    private LevelAccount status;
    private double cashback;
    private String numberCard;
    private double money;
    private boolean first;

    public Account(String fName, String sName, String otecName, LevelAccount status, int renta, double cashback) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 20; i++) {
            int c = r.nextInt(9);
            if (i % 4 == 0){
                sb.append(" ");
            }
            sb.append(c);
        }
        this.fName = fName;
        this.sName = sName;
        this.otecName = otecName;
        this.status = status;
        this.renta = renta;
        this.cashback = cashback;
        this.numberCard = sb.toString();
        this.first = true;
    }

    public double getCashback() { return this.cashback; }
    public String getNumberCard() { return this.numberCard; }
    public double getMoney() {
        System.out.println("счёт: " + this.fName + ", баланс: " + this.money);
        return this.money;
    }

    protected void withdraw(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма снятия должна быть положительной, а ваша: " + amount);
        }
        if (this.money < amount) {
            throw new InsufficientFundsException("Недостаточно средств на счете " + this.numberCard + ". Баланс: " + this.money + ", Запрос: " + amount);
        }
        this.money -= amount;
    }

    public void addMoney(double money) {
        this.money = this.money + money;
    }

    public void transferMoney(Account toAccount, double count){
        this.withdraw(count);
        toAccount.addMoney(count);
        System.out.println("сумма перевода: "+ count);
        System.out.println("остаток баланса: "+ this.money);
    }

    public void paymentService(double count){
        if (this.first) {
            addMoney(1000);
            this.first = false;
        }
        this.withdraw(count);
        System.out.println("сумма оплаты: "+ count);
        System.out.println("кэшбэк: "+ this.calculateCashback(count));
        System.out.println("остаток баланса: "+ this.money + "\n");
        this.addMoney(calculateCashback(count));
    }

    public double calculateCashback(double count) {
        if (count >= 10000) {
            return count * this.cashback;
        }
        return 0;
    }
}