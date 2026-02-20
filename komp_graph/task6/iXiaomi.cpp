#include <iostream>
#include <string>

using namespace std;

class IPhone {
public:
    double diagonal;
    int ggc;

    string ShowIphone() {
        return "IPhone с диагональю " + to_string(diagonal) + " и частотой процессора " + to_string(ggc) + " ћ√ц";
    }
};

class Xiaomi {
public:
    double diagonal; 
    int cpuFrequency;

    string ShowXiaomi() {
        return "Xiaomi с диагональю " + to_string(diagonal) + " и частотой процессора " + to_string(cpuFrequency) + " ћ√ц";
    }
};

int main() {
    setlocale(LC_ALL, "RU");

    IPhone iphone;
    Xiaomi xiaomi;

    iphone.diagonal = 6.1;
    iphone.ggc = 2650;

    xiaomi.diagonal = 6.67;
    xiaomi.cpuFrequency = 2840;

    string(IPhone:: * showIphonePtr)() = &IPhone::ShowIphone;
    string(Xiaomi:: * showXiaomiPtr)() = &Xiaomi::ShowXiaomi;

    cout << (iphone.*showIphonePtr)() << endl;
    cout << (xiaomi.*showXiaomiPtr)() << endl;

    return 0;
}
