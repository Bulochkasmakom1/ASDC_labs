#include <iostream>
#include <fstream>
#include <string>
#include <vector>


using namespace std;

// ����������� ��������� ������ ������� ��������� �����������
class Employee {
    string surname;
    string name;
    string position;
    string salary_category;
    int experience;
    long long IDNP;

public:

    // ����������� �� ���������
    Employee();

    // ����������� �����������
    Employee(const Employee& other);

    // �������� �����������
    Employee operator = (const Employee& other);


    // �������� ���������
    bool operator==(const Employee& other) const;

    // �������� ������ �� ������
    friend istream& operator>>(istream& in, Employee& employee);

    // �������� ������ � �����
    friend ostream& operator<<(ostream& out, const Employee& employee);
};
