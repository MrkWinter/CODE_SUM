#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
using namespace std;
class Animal {
private:
	int age;
public:
	virtual void cry() {
		cout << "jiao" << endl;
	}
};
class Cat:public Animal {
public:
	void cry() {
		cout << "haha" << endl;
	}
}; 
int main() {
	Animal* cat = new Cat();
	cat->cry();
	cat = new Animal();
	cat->cry();
	return 0;
}