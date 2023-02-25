#include <vector>
#include <strstream>
#include "Employee.h"


using namespace std;

//���������� ������ �� �����������
const vector<string> explode(const string& str, const char& delimiter)
{
    string buff{ "" };
    vector<string> result;

    for (auto chr : str)
    {
        if (chr != delimiter)
            buff += chr;
        else if (chr = delimiter && buff != "")
        {
            result.push_back(buff);
            buff = "";
        }
    }
    if (buff != "")
        result.push_back(buff);
    return result;
}

// ����������� �� ���������
Employee::Employee() : surname(""), name(""), position(""), salary_category(""), experience(0), IDNP(0) {}

// ����������� �����������
Employee::Employee(const Employee& other)
{
    surname = other.surname;
    name = other.name;
    position = other.position;
    salary_category = other.salary_category;
    experience = other.experience;
    IDNP = other.IDNP;
}

// �������� �����������
Employee Employee::operator = (const Employee& other)
{
    surname = other.surname;
    name = other.name;
    position = other.position;
    salary_category = other.salary_category;
    experience = other.experience;
    IDNP = other.IDNP;

    return *this;
}

// �������� ���������
bool Employee::operator==(const Employee& other) const 
{
    return IDNP == other.IDNP;
}

// �������� ������ �� ������
istream &operator>>(istream &in, Employee &employee) 
{
    char delimiter = ',';
    string str;
    getline(in, str);

    auto chunks = explode(str, delimiter);

    employee.surname = chunks[0];
    employee.name = chunks[1];
    employee.position = chunks[2];
    employee.salary_category = chunks[3];
    employee.experience = stoi(chunks[4]);
    employee.IDNP = stol(chunks[5]);
    return in;
}

// �������� ������ � �����
ostream &operator<<(ostream& out, const Employee& employee) 
{
    out << employee.surname << " " << employee.name << " " << employee.position
        << " " << employee.salary_category << " " << employee.experience << " " << employee.IDNP;
    return out;
}