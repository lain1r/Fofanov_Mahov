//#include <iostream>
//using namespace::std;
//int LENGHT_ARR = 6;
//int main()
//{
//    setlocale(LC_ALL, "Russian");
//
//    int* arr = new int[LENGHT_ARR];
//    cout << "Введите 1-й элемент: ";
//    cin >> arr[0];
//    cout << "Введите 2-й элемент: ";
//    cin >> arr[1];
//    cout << "Введите 3-й элемент: ";
//    cin >> arr[2];
//    cout << "Введите 4-й элемент: ";
//    cin >> arr[3];
//    cout << "Введите 5-й элемент: ";
//    cin >> arr[4];
//    cout << "Введите 6-й элемент: ";
//    cin >> arr[5];
//
//    cout << "Исходный массив: ";
//    for (int i = 0; i < LENGHT_ARR; i++) {
//        cout << arr[i] << " ";
//    }
//    cout << endl;
//    int* arr2 = new int[LENGHT_ARR];
//    for (int i = 0; i < 6; i= i+2) {
//        arr2[i] = arr[i+1];
//        arr2[i+1] = arr[i];
//    }
//
//    for (int i = 0; i < 6; i++) {
//        arr[i] = arr2[i];
//    }
//    delete[] arr2;
//
//    cout << "Измененный массив: ";
//    for (int i = 0; i < LENGHT_ARR; i++) {
//        cout << arr[i] << " ";
//    }
//    cout << endl;
//
//    delete[] arr;
//}