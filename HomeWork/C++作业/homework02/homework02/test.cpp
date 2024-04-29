#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
using namespace std;
class Counter {
private:
	int n;
public:
	Counter() {};
	Counter(int x) :n(x) {}; //�ù��������б��ʼ����ʽ��ʼ������
	Counter operator + (Counter &another) const;
	Counter operator - (Counter & another) const;
	int getN();
};
Counter Counter::operator+(Counter &another) const{
	return Counter(this->n + another.n);
}
Counter Counter::operator - (Counter & another) const {
	return Counter(this->n - another.n);
}
int Counter::getN() {
	return n;
}
int main() {
	Counter c4();
	Counter c = Counter();
	Counter c1 = Counter(3);
	Counter c2 = Counter(4);
	c = c1 + c2;
	cout << c.getN() << endl;
	c = c1 - c2;
	cout << c.getN() << endl;
	system("pause");
	return 0;
}
