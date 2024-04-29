#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
#include<sstream>
using namespace std;
class Teacher {
private:
	string name;
	int age;
	string duty = "教学";
public:
	Teacher(string name, int age) : name(name), age(age) {};
	string showTeacherInformation();
	string getDuty();
};
string Teacher::showTeacherInformation() {
	ostringstream oss;
	oss << "姓名：" + name + " 年龄：" << age << "  职责：" + duty;
	return oss.str();
}
string Teacher::getDuty() {
	return duty;
}
class Student {
private:
	string name;
	int age;
	string duty = "学习";
public:
	Student(string name, int age) : name(name), age(age) {};
	string showStudentInformation();
	string getDuty();
};
string Student::showStudentInformation() {
	ostringstream oss;
	oss << "姓名：" + name + "  年龄：" << age << "  职责：" + duty;
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
	oss << "姓名：" + name + "  年龄：" << age << "  学号：" << id << "  职责：" +
		Student::getDuty() + " " + Teacher::getDuty() << endl;
	return oss.str();
}
int main() {
	Teacher t1 = Teacher("张三", 23);
	cout << t1.showTeacherInformation() << endl;
	Student s1 = Student("李四",16);
	cout << s1.showStudentInformation() << endl;
	Graduate g1 = Graduate("王五", 20,12233222);
	cout << g1.showGraduateInformation() << endl;
	system("pause");
	return 0;
}