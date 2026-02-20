#include <iostream> 
#include <cmath>  

using namespace std;


double calculateFunction(double x, int variant) {

    switch (variant) {
    case 1:
        return -sin(x - 5);

    case 2:
        if (x == 0) {
            cout << "Ошибка: логарифм от нуля не определен!" << endl;
            break;
        }
        return log(x * x);

    case 3:
        return sin(x - 5);

    case 4:
        return pow(2, x);

    case 5:
        double cos_val = cos(x + 5);
        return cos_val * cos_val;
    }
}

int main() {

    setlocale(LC_ALL, "Russian");

    int continueChoice;

    do {
        int variantChoice;
        cout << "Выберите функцию для вычисления (1-5):" << endl;
        cout << "1. F(x) = -sin(x - 5)" << endl;
        cout << "2. F(x) = ln(x^2)" << endl;
        cout << "3. F(x) = sin(x - 5)" << endl;
        cout << "4. F(x) = 2^x" << endl;
        cout << "5. F(x) = cos^2(x + 5)" << endl;
        cout << "Ваш выбор: ";
        cin >> variantChoice;

        double x;
        cout << "Введите число x: ";
        cin >> x;

        double result = calculateFunction(x, variantChoice);

        cout << "Результат F(x) = " << result << endl;

        cout << "\nПродолжить вычисления? (1 - да, 0 - нет): ";
        cin >> continueChoice;

    } while (continueChoice == 1);

    cout << "Программа завершена." << endl;

    return 0;
}