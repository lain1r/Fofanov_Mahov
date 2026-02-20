#include <iostream>
#include <cstdlib>
#include <ctime>  
#include <string>

using namespace std;


int main() {
    setlocale(LC_ALL, "Russian");
    srand(time(NULL));
    int arr[10];
    int c;
    int count;
    bool b = false;
    
    for (int i = 0; i < 10; i++) {
        arr[i] = rand() % 1000;
        cout << arr[i] << ", ";        
    }

    cout << "Введите число\n";
    cin >> c;


    for (int i = 0; i < 10; i++) {
        if (arr[i] == c) {
            count = i;
            b = true;
            continue;
        }
    }

    if (b) {
        cout << count+1 << "- место числа в массиве\n";
    }
    else {
        cout << "не найдено число\n";
    }


    return 0;
}