#include <iostream>
#include <fstream>
#include <string>
#include <vector>


using namespace std;

// Определение структуры данных записей работника предприятия
struct Employee {
    string surname;
    string name;
    string position;
    string salary_category;
    int experience;
    long long IDNP;

    // Конструктор по умолчанию
    Employee() : surname(""), name(""), position(""), salary_category(""), experience(0), IDNP(0) {}

    // Конструктор копирования
    Employee(const Employee& other) {
        surname = other.surname;
        name = other.name;
        position = other.position;
        salary_category = other.salary_category;
        experience = other.experience;
        IDNP = other.IDNP;
    }

    // Оператор копирования
    Employee* clone() const {
        return new Employee(*this);
    }

    // Оператор сравнения
    bool operator==(const Employee& other) const {
        return IDNP == other.IDNP;
    }

    // Оператор чтения из потока
    friend istream& operator>>(istream& in, Employee& employee) {
        in >> employee.surname >> employee.name >> employee.position
            >> employee.salary_category >> employee.experience >> employee.IDNP;
        return in;
    }

    // Оператор записи в поток
    friend ostream& operator<<(ostream& out, const Employee& employee) {
        out << employee.surname << " " << employee.name << " " << employee.position
            << " " << employee.salary_category << " " << employee.experience << " " << employee.IDNP;
        return out;
    }
};

int main() {

    // Чтение данных из файла csv
    ifstream file("employees.csv");
    if (!file)
    {
        cerr << "Failed to open file" << endl;
        return 1;
    }

    // Вывод данных на экран
    string line;
    while (getline(file, line))
    {
        cout << line << endl;
    }


    // Закрытие файла
    file.close();

    return 0;
}


