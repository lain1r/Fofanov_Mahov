#include <iostream>
#include <string>

using namespace std;

class ProductBatch {
protected:
    int totalQuantity;
    string productName;
    int deliveryDay;
    int deliveryMonth;
    int deliveryYear;
    int soldQuantity;
    int writtenOffQuantity;

public:
    ProductBatch() : totalQuantity(0), deliveryDay(1), deliveryMonth(1),
        deliveryYear(2000), soldQuantity(0), writtenOffQuantity(0) {
    }

    int getOst() {
        int remaining = totalQuantity - soldQuantity - writtenOffQuantity;
        return (remaining < 0) ? 0 : remaining;
    }

    void init(int total, string name, int day, int month, int year) {
        setlocale(LC_ALL, "Russian");
        cout << "  Параметры: total=" << total << ", name=" << name
            << ", date=" << day << "." << month << "." << year << endl;

        totalQuantity = total;
        productName = name;
        deliveryDay = day;
        deliveryMonth = month;
        deliveryYear = year;
        soldQuantity = 0;
        writtenOffQuantity = 0;
    }

    void sell(int quantity = 1) {
        cout << "  Параметр: quantity=" << quantity << endl;

        int remaining = getOst();
        if (quantity <= 0) {
            cout << "Количество должно быть положительным." << endl;
        }
        else if (quantity > remaining) {
            cout << "Недостаточно товара. В наличии: " << remaining
                << " Запрошено: " << quantity << endl;
        }
        else {
            soldQuantity += quantity;
            cout << "Продано " << quantity << " шт." << endl;
        }
    }

    void spisanie(int quantity = 1) {
        cout << "списание=" << quantity << endl;

        int remaining = getOst();
        if (quantity <= 0) {
            cout << "Количество должно быть положительным." << endl;
        }
        else if (quantity > remaining) {
            cout << "Недостаточно товара для списания. В наличии: "
                << remaining << ", Запрошено: " << quantity << endl;
        }
        else {
            writtenOffQuantity += quantity;
            cout << "Списано " << quantity << " шт." << endl;
        }
    }

    void printOst() {
        cout << "  Остаток товара '" << productName << "': "
            << getOst() << " шт." << endl;
    }

    void printFullReport() {
        cout << "Полный отчет по партии: " << productName << endl;
        cout << "Дата поставки: " << deliveryDay << "."
            << deliveryMonth << "." << deliveryYear << endl;
        cout << "Начальное количество: " << totalQuantity << " шт." << endl;
        cout << "Продано: " << soldQuantity << " шт." << endl;
        cout << "Списано: " << writtenOffQuantity << " шт." << endl;
        cout << "------------------------------------" << endl;
        cout << "Текущий остаток: " << getOst() << " шт." << endl;
        cout << "------------------------------------" << endl;
    }
};


class PackagedProductBatch : public ProductBatch {
private:
    int itemsPerPackage; 
    int totalPackages;   

    int getRemainingPackages() {
        int remaining = getOst();
        return remaining / itemsPerPackage;
    }

public:
    PackagedProductBatch() : itemsPerPackage(0), totalPackages(0) {}

    void init(int itemsPerPack, int packages, string name, int day, int month, int year) {
        setlocale(LC_ALL, "Russian");
        cout << "  Параметры: itemsPerPack=" << itemsPerPack << ", packages=" << packages
            << ", name=" << name << ", date=" << day << "." << month << "." << year << endl;

        itemsPerPackage = itemsPerPack;
        totalPackages = packages;
        totalQuantity = itemsPerPackage * totalPackages;
        productName = name;
        deliveryDay = day;
        deliveryMonth = month;
        deliveryYear = year;
        soldQuantity = 0;
        writtenOffQuantity = 0;
    }

    void sellPackage(int packages = 1) {
        cout << "  Продажа упаковками: packages=" << packages << endl;
int remainingPacks = getRemainingPackages();
        if (packages <= 0) {
            cout << "Количество упаковок должно быть положительным." << endl;
        }
        else if (packages > remainingPacks) {
            cout << "Недостаточно упаковок. В наличии: " << remainingPacks
                << " упаковок, Запрошено: " << packages << endl;
        }
        else {
            int quantity = packages * itemsPerPackage;
            soldQuantity += quantity;
            cout << "Продано " << packages << " упаковок (" << quantity << " шт.)" << endl;
        }
    }

    void sell(int quantity = 1) {
        cout << "  Продажа поштучно: quantity=" << quantity << endl;

        int remaining = getOst();
        if (quantity <= 0) {
            cout << "Количество должно быть положительным." << endl;
        }
        else if (quantity > remaining) {
            cout << "Недостаточно товара. В наличии: " << remaining
                << " шт., Запрошено: " << quantity << endl;
        }
        else {
            soldQuantity += quantity;
            cout << "Продано " << quantity << " шт." << endl;
        }
    }

    void spisanie(int quantity = 1) {
        cout << "  Списание поштучно: quantity=" << quantity << endl;

        int remaining = getOst();
        if (quantity <= 0) {
            cout << "Количество должно быть положительным." << endl;
        }
        else if (quantity > remaining) {
            cout << "Недостаточно товара для списания. В наличии: "
                << remaining << " шт., Запрошено: " << quantity << endl;
        }
        else {
            writtenOffQuantity += quantity;
            cout << "Списано " << quantity << " шт." << endl;
        }
    }

    void printOst() {
        int remaining = getOst();
        int remainingPacks = getRemainingPackages();
        cout << "  Остаток товара '" << productName << "': "
            << remaining << " шт. (" << remainingPacks << " полных упаковок)" << endl;
    }

    void printFullReport() {
        int remainingPacks = getRemainingPackages();
        cout << "Полный отчет по партии: " << productName << endl;
        cout << "Дата поставки: " << deliveryDay << "."
            << deliveryMonth << "." << deliveryYear << endl;
        cout << "Начальное количество: " << totalPackages << " упаковок ("
            << totalQuantity << " шт.)" << endl;
        cout << "Количество в упаковке: " << itemsPerPackage << " шт." << endl;
        cout << "Продано: " << soldQuantity << " шт." << endl;
        cout << "Списано: " << writtenOffQuantity << " шт." << endl;
        cout << "------------------------------------" << endl;
        cout << "Текущий остаток: " << getOst() << " шт." << endl;
        cout << "Целых упаковок: " << remainingPacks << endl;
        cout << "------------------------------------" << endl;
    }
};

void showMenu() {
    cout << "\nМеню управления партией" << endl;
    cout << "1. Продать 1 шт. (по умолч.)" << endl;
    cout << "2. Продать (указать кол-во)" << endl;
    cout << "3. Списать 1 шт. (по умолч.)" << endl;
    cout << "4. Списать (указать кол-во)" << endl;
    cout << "5. Продать 1 упаковку (по умолч.)" << endl;
    cout << "6. Продать упаковками (указать кол-во)" << endl;
    cout << "7. Показать остаток" << endl;
    cout << "8. Показать полный отчет" << endl;
    cout << "0. Выход" << endl;
    cout << "Ваш выбор: ";
}

void test1(PackagedProductBatch& batch) {
    cout << "\n" << endl;
    batch.sell(10);
    batch.sell();
    batch.spisanie(5);
    batch.sellPackage(1);
    batch.sell(15);
    cout << "Тест 1 Завершен" << endl;
}

void test2(PackagedProductBatch& batch) {
    cout << "\n" << endl;
    batch.sellPackage(10);
    batch.sell(100);
    batch.spisanie(50);
    cout << "Тест 2 Завершен" << endl;
}

void test3(PackagedProductBatch& batch) {
    cout << "\n" << endl;
    batch.sell();
    batch.spisanie();
    batch.sellPackage();
    batch.sell(2);
    batch.spisanie();
    batch.sell();
    batch.sellPackage();
    cout << "Тест 3 Завершен" << endl;
}
int main() {
    setlocale(LC_ALL, "Russian");

    PackagedProductBatch mainBatch;

    int itemsPerPack, packages, d, m, y;
    string name;
    int testChoice;

    cout << "Инициализация новой партии" << endl;

    cout << "Введите наименование товара: ";
    getline(cin, name);

    cout << "Введите количество товара в одной упаковке: ";
    cin >> itemsPerPack;

    cout << "Введите общее число упаковок: ";
    cin >> packages;

    cout << "Введите дату поставки (ДД ММ ГГГГ): ";
    cin >> d >> m >> y;

    mainBatch.init(itemsPerPack, packages, name, d, m, y);

    do {
        cout << "\n1. Тест 1 (Стандартные операции)" << endl;
        cout << "2. Тест 2 (Проверка ошибок нехватки)" << endl;
        cout << "3. Тест 3 (Операции по умолчанию)" << endl;
        cout << "0. Выход" << endl;
        cout << "Введите номер теста (0-3): ";
        cin >> testChoice;

        switch (testChoice) {
        case 1:
            test1(mainBatch);
            break;
        case 2:
            test2(mainBatch);
            break;
        case 3:
            test3(mainBatch);
            break;
        case 0:
            cout << "Выход из программы." << endl;
            break;
        default:
            cout << "Неверный выбор. Запуск Теста 1 по умолчанию." << endl;
            test1(mainBatch);
            break;
        }
    } while (testChoice != 0);

    cout << "\n--- Итоги после проведения теста ---" << endl;
    mainBatch.printOst();
    cout << endl;
    mainBatch.printFullReport();

    return 0;
}