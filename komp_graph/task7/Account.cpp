#include <iostream>
#include <string>

using namespace std;

class Account {
private:
    string accountName;
    double saldo;
    double expense;
    double income;
    double remainder;

public:
    static double totalMoneyInCashbox;

    Account(string name, double initialBalance) :
        accountName(name),
        saldo(initialBalance),
        expense(0),
        income(0),
        remainder(initialBalance)
    {
        totalMoneyInCashbox += initialBalance;
    }

    ~Account() {
        totalMoneyInCashbox -= remainder;
    }

    void addExpense(double amount) {
        if (amount <= 0) {
            return;
        }
        if (amount > remainder) {
            return;
        }

        expense += amount;
        remainder -= amount;
        totalMoneyInCashbox -= amount;
    }

    void addIncome(double amount) {
        if (amount <= 0) {
            return;
        }

        income += amount;
        remainder += amount;
        totalMoneyInCashbox += amount;
    }

    void displayInfo() const {
        cout << "\n=== Информация о счете ===" << endl;
        cout << "Название счета: " << accountName << endl;
        cout << "Начальное сальдо: " << saldo << endl;
        cout << "Общий расход: " << expense << endl;
        cout << "Общий доход: " << income << endl;
        cout << "Текущий остаток: " << remainder << endl;
        cout << "==========================\n" << endl;
    }

    string getAccountName() const { return accountName; }
    double getBalance() const { return saldo; }
    double getExpense() const { return expense; }
    double getIncome() const { return income; }
    double getRemainder() const { return remainder; }

    static string getGreeting() {
        return "Ваш приветствует Наш Банк";
    }

    static void displayTotalMoney() {
        cout << "Всего денег в кассе: " << totalMoneyInCashbox << endl;
    }
};

double Account::totalMoneyInCashbox = 0;

class Bank {
protected:
    double bankPercent;

public:
    Bank(double percent) : bankPercent(percent) {}

    virtual void GetPercent(double sum) {
        double percentAmount = (sum * bankPercent) / 100.0;
        cout << "Ваш процент по банку составляет: " << percentAmount << endl;
    }

    virtual ~Bank() {}
};

class MicroBank : public Bank {
private:
    double microPercent;

public:
    MicroBank(double microPercent, double bankPercent) :
        Bank(bankPercent), microPercent(microPercent) {
    }

    void GetPercent(double sum) override {
        double totalPercent = bankPercent + microPercent;
        double percentAmount = (sum * totalPercent) / 100.0;
        cout << "Ваш процент по микробанку составляет: " << percentAmount << endl;
    }
};

int main() {
    setlocale(LC_ALL, "RU");    

    cout << Account::getGreeting() << endl;

    Account account1("Основной счет", 10000.0);
    Account account2("Накопительный счет", 5000.0);

    account1.addIncome(2000.0);
    account1.addExpense(3000.0);

    account2.addIncome(1000.0);
    account2.addExpense(1500.0);

    account1.displayInfo();
    account2.displayInfo();

    Account::displayTotalMoney();

    Bank* bank1 = new Bank(5.0);
    Bank* microBank1 = new MicroBank(3.0, 5.0);

    cout << "\nПроцент по обычному банку для суммы 1000:" << endl;
    bank1->GetPercent(1000.0);

    cout << "\nПроцент по микробанку для суммы 1000:" << endl;
    microBank1->GetPercent(1000.0);

    delete bank1;
    delete microBank1;

    return 0;
}