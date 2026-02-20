//#include <iostream>
//#include <string>
//
//using namespace std;
//
//
//
//
//int main() {
//    setlocale(LC_ALL, "Russian");
//    char c;
//    char cz;
//    string s;
//    int count = 0;
//
//    s = "qwdscvgfrtuyhjnbv";
//
//    cout << s <<"\nВведите символ\n";
//    cin >> c;
//
//    cout << "Введите символ для замены\n";
//    cin >> cz;
//
//    for (int i = 0; i < s.length(); i++) {
//        if (s[i] == c) {
//            s[i] = cz;
//            cout << s << "\n символ заменен";
//            count++;
//        }
//    }
//
//    if (count == 0) {
//        cout << "символ не найден";
//    }
//
//    return 0;
//}