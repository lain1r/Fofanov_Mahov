//#include <iostream>
//using namespace std;
//class Car {
//private:
//    string name;
//    int speed;
//public:
//    Car(string cName, int cSpeed) {
//        name = cName;
//        speed = cSpeed;
//    }
//
//    bool equalsSpeed(int sSpeed) {
//        if (speed == sSpeed) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//    string sravSpeed(int sSpeed) {
//        if (speed > sSpeed) {
//            return "первая машина быстрее";
//        } else if (speed == sSpeed){
//            return "скорость одинакова";
//        } else { 
//            return "вторая машина быстрее";
//        }
//    }
//    
//    int getSpeed() {
//        return speed;
//    }
//
//    void getCarInfo() {;
//        cout << "название " << name <<"скорость " << speed << endl;
//    }
//};
//
//
//int main()
//{
//    setlocale(LC_ALL, "Russian");
//
//    Car bmw("bmw", 200);
//    Car volkswagen("volkswagen", 150);
//    bmw.getCarInfo();
//    volkswagen.getCarInfo();
//
//    cout << bmw.equalsSpeed(volkswagen.getSpeed()) << endl;
//    cout << bmw.sravSpeed(volkswagen.getSpeed()) << endl;
//}