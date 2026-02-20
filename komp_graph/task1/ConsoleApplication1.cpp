#include <iostream>
#include <math.h>

using namespace std;

int main() {
    setlocale(LC_ALL, "Russian");
    double n;
    double n2;

    cout << "введите первое число ";
    cin >> n;
    cout << "введите первое число ";
    cin >> n2;

    if (n > n2) {
        cout <<"\n" << -sin(n - 5) << "- первая функция\n";
    }
    else {
        cout << "\n" << -sin(n2 - 5) << "- первая функция\n";
    }
       

    if (n > n2) {
        cout << log(pow(n, 2)) << "- вторая функция\n";
    }
    else {
        cout << log(pow(n2, 2)) << "- вторая функция\n";
    }


    if (n > n2) {
        cout << sin(n - 5) << "- третья функция\n";
    }
    else {
        cout << sin(n2 - 5) << "- третья функция\n";
    }


    if (n > n2) {
        cout << pow(2, n2) << "- четвёртая функция\n";
    }
    else {
        cout << pow(2, n2) << "- четвёртая функция\n";
    }


    if (n > n2) {
        cout << pow(cos(n + 5), 2) << "- пятая функция\n";
    }
    else {
        cout << pow(cos(n2 + 5), 2) << "- пятая функция\n";
    }
    return 0;
}