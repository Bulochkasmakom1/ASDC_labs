#include <iostream>
#include <fstream>
#include <string>
#include <vector>


using namespace std;

// Определение структуры данных записей работника предприятия
class Employee {
    string surname;
    string name;
    string position;
    string salary_category;
    int experience;
    long long IDNP;

public:

    // Конструктор по умолчанию
    Employee();

    // Конструктор копирования
    Employee(const Employee& other);

    // Оператор копирования
    Employee operator = (const Employee& other);


    // Оператор сравнения
    bool operator==(const Employee& other) const;

    // Оператор чтения из потока
    friend istream& operator>>(istream& in, Employee& employee);

    // Оператор записи в поток
    friend ostream& operator<<(ostream& out, const Employee& employee);
};
