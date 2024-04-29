#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
using namespace std;
//������
class Shape {
public:
	virtual double getArea() = 0;
	virtual double getLen() = 0;
};
//ʵ���� Rectangle
class Rectangle : public Shape {
private:
	double length;
	double width;
public:
	Rectangle(double length, double width) : length(length), width(width) {};
	virtual double getArea();
	virtual double getLen();
};
double Rectangle::getArea() {
	return length * width;
}
double Rectangle::getLen() {
	return 2 * (length + width);
}
//ʵ���� Circle
class Circle : public Shape {
private:
	double radius;
	static double pi;
public:
	Circle(double radius) : radius(radius) {};
	virtual double getArea();
	virtual double getLen();
};
double Circle::pi = 3.1415926;
double Circle::getArea() {
	return pi * radius*radius;
}
double Circle::getLen() {
	return 2 * pi * radius;
}
int main() {
	
	Shape *s1 = new Rectangle(4, 5);
	cout << "�������Ϊ��" << s1->getArea() << endl;
	cout << "�����ܳ�Ϊ��" << s1->getLen() << endl;
	s1 = &Circle(3);
	cout << "Բ�����Ϊ��" << s1->getArea() << endl;
	cout << "Բ���ܳ�Ϊ��" << s1->getLen() << endl;
	system("pause");
	return 0;
}  