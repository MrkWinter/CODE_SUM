#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
#include<sstream>
using namespace std;
class Teacher {
private:
	string name;
	int age;
	string duty = "��ѧ";
public:
	Teacher(string name, int age) : name(name), age(age) {};
	string showTeacherInformation();
	string getDuty();
};
string Teacher::showTeacherInformation() {
	ostringstream oss;
	oss << "������" + name + " ���䣺" << age << "  ְ��" + duty;
	return oss.str();
}
string Teacher::getDuty() {
	return duty;
}
class Student {
private:
	string name;
	int age;
	string duty = "ѧϰ";
public:
	Student(string name, int age) : name(name), age(age) {};
	string showStudentInformation();
	string getDuty();
};
string Student::showStudentInformation() {
	ostringstream oss;
	oss << "������" + name + "  ���䣺" << age << "  ְ��" + duty;
	return oss.str();
}
string Student::getDuty() {
	return duty;
}
class Graduate : public Teacher,public Student {
private:
	string name;
	int age;
	int id;
public:
	Graduate(string name, int age, int id);
	string showGraduateInformation();
};
Graduate::Graduate(string name, int age, int id) : 
	Teacher(name, age), Student(name, age) {
	this->name = name;
	this->age = age;
	this->id = id;
}
string Graduate::showGraduateInformation() {
	ostringstream oss;
	oss << "������" + name + "  ���䣺" << age << "  ѧ�ţ�" << id << "  ְ��" +
		Student::getDuty() + " " + Teacher::getDuty() << endl;
	return oss.str();
}
int main() {
	Teacher t1 = Teacher("����", 23);
	cout << t1.showTeacherInformation() << endl;
	Student s1 = Student("����",16);
	cout << s1.showStudentInformation() << endl;
	Graduate g1 = Graduate("����", 20,12233222);
	cout << g1.showGraduateInformation() << endl;
	system("pause");
	return 0;
}