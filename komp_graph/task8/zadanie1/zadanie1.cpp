//#include <iostream>
//#include <fstream>
//#include <string>
//#include <vector>
//#include <algorithm>
//
//
//const int MAX_SIZE = 40;
//
//int main()
//{
//    setlocale(LC_ALL, "RU");
//
//    std::string se;
//    std::ofstream file1("file.txt");
//    std::ofstream file2("file2.txt");
//
//    std::string word[MAX_SIZE] = {
//        "абракадабра", "экзистенциальный", "параллелепипед", "электроэнцефалография",
//        "трансцендентальный", "субстанционализация", "рентгеноэлектрокардиографический",
//        "бесперспективняк", "интерференция", "фотосинтез", "достопримечательность",
//        "кристаллизация", "подсознательный", "человеконелюбие", "синхрофазотрон",
//        "дезоксирибонуклеиновая", "робототехника", "водопроводный", "пульсировать",
//        "взбзднуть", "метоксихлордиэтиламинометилбутиламиноакридин", "кот", "лес", "дом",
//        "книга", "стул", "океан", "солнце", "яблоко", "ноутбук", "алфавит", "велосипед",
//        "молния", "расчески", "квартира", "пылесос", "впечатление", "ты", "мы", "стул"
//    };
//
//    std::vector<std::string> buffer;
//
//    
//
//    if (!file1.is_open()) {
//        std::cerr << "Не удалось открыть файл!" << std::endl;
//        std::cerr << "Текущая директория: ";
//        system("cd");
//        return 1;
//    }
//    else {
//        for (int i = 0; i < MAX_SIZE; i++) {
//            if (word[i].length() < 80) {
//                file1 << word[i] << std::endl;
//            }
//        }
//        std::cout << "файли записан" << std::endl;
//    }   
//
//
//
//    if (!file2.is_open()) {
//        std::cerr << "Не удалось открыть файл 2!" << std::endl;
//        std::cerr << "Текущая директория: ";
//        system("cd");
//        return 1;
//    }
//    else {
//
//        std::ifstream file1("file.txt");
//
//        while (std::getline(file1, se)) {
//            int a = 0;
//            buffer.push_back(se);
//            a++;
//        }
//
//        std::sort(buffer.begin(), buffer.end());
// 
//        for (int i = 0; i < MAX_SIZE; i++) {
//
//            file2 << buffer[i] << std::endl;
//           
//        }
//        std::cout << "файли записан" << std::endl;
//    }
//
//    file1.close();
//    file2.close();
//    return 0;
//}
