#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
using namespace std;
//抽象类
class Shape {
public:
	virtual double getArea() = 0;
	virtual double getLen() = 0;
};
//实现类 Rectangle
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
//实现类 Circle
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
	cout << "矩形面积为：" << s1->getArea() << endl;
	cout << "矩形周长为：" << s1->getLen() << endl;
	s1 = &Circle(3);
	cout << "圆形面积为：" << s1->getArea() << endl;
	cout << "圆形周长为：" << s1->getLen() << endl;
	system("pause");
	return 0;
}  