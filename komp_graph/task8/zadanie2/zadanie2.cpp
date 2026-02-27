#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <typeinfo>

using namespace std;

int main()
{   setlocale(LC_ALL, "RU");
    int newB;
    string a;
    string b;
    ofstream of("primer1.txt");
    
    if (of.is_open()) {
        cout << "напишите число" << endl;
        cin >> a;
        of << a << endl;
        cout << "число " << a << " записано в файл primer1" << endl;
    }
    of.close();

    ifstream in("primer1.txt");
    ofstream of2("primer2.txt");


        if (of2.is_open() && in.is_open()) {
            getline(in, b);
            try {
                newB = stoi(b);
            }
            catch (const exception e) {
                e.what();
                newB = NULL;
                cout << "В файле строка.Необходимо число" << endl;
                return 0;
            }

            of2 << newB << endl;
            cout << "число " << newB << " записано в файл primer2" << endl;
        }
  

    return 0;
}
