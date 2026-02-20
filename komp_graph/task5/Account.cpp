#include <iostream>
using namespace::std;

class Account {
private:
    string name;    
    int age;        
    double rashod; 
    double dahod;  

public:
    Account(string n, int a, double rash, double dah)
        : name(n), age(a), rashod(rash), dahod(dah) {
    }

    void slosh(int n) {
        dahod += n;
    }

    void vich(int n) {
        rashod += n;
    }

    void operation(int n) {
        if (n > 0) {
            dahod += n;
        }
        else if (n < 0) {
            rashod += abs(n);
        }
    }

    // Для вывода
    void getInfo() const {
        cout << "Account: " << name
            << ", Age: " << age
            << ", rashod: " << rashod
            << ", dahod: " << dahod << endl;
    }

};

int main()
{
    setlocale(LC_ALL, "Russian");

    Account max("Max", 18, 0, 0);

    max.slosh(200);
    max.getInfo();

    max.vich(200);
    max.getInfo();
   
    max.operation(200);
    max.getInfo();
   
    max.operation(-200);
    max.getInfo();

    
    return 0;
}