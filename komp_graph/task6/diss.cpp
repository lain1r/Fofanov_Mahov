//#include <iostream>
//using namespace std;
//
//void decrementWithoutPointer(int x) {
//    x--;
//    cout << "Внутри = " << x << endl;
//}
//
//void decrementWithPointer(int* x) {
//    (*x)--;
//    cout << "Внутри = " << *x << endl;
//}
//
//int main() {
//    setlocale(LC_ALL, "RU");
//
//    int num;
//
//    cout << "Введите первое число "<< endl;
//    cin >> num;
//
//
//    cout << "До = " << num << endl;
//    decrementWithoutPointer(num);
//    cout << "После = " << num << endl;
//
//    cout << endl;
//
//    cout << "До = " << num << endl;
//    decrementWithPointer(&num);
//    cout << "После = " << num << endl;
//
//    return 0;
//}