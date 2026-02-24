#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{   setlocale(LC_ALL, "RU");
    int a;
    
    cin >> a;
    ofstream of("primer1.txt");
    of << a << endl;

    return 0;
}
