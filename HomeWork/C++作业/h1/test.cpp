#define _CRT_SECURE_NO_WARNINGS 1
#include<iostream>
#include<string>
#define NUM 30
using namespace std;
typedef struct record {
	string time;
	double amount;
}record;
//bank��
class Bank {
private:
	int count;
	string crDate;
	double balance;
	record arrRecord[NUM];//��30�ļ�¼
	int index = 0;
public:
	Bank(int count, string crDate, double balance);
	void saveOrTakeMoney();
	void showRecord();

};
Bank::Bank(int count, string crDate, double balance) {
	this->count = count;
	this->crDate = crDate;
	this->balance = balance;
}
void Bank::saveOrTakeMoney() {
	cout << "�������Ǯ��ȡǮ����" << endl;
	cin >> arrRecord[index].amount;
	if (balance + arrRecord[index].amount < 0) {
		cout << "�˻�����" << endl;
		return;
	}
	this->balance += arrRecord[index].amount;
	cout << "���������ڣ�" << endl;
	cin >> arrRecord[index].time;//�����������Ϣ
	index = (++index) % 30;
}
void Bank::showRecord() {
	cout << "---�����ǽ��ڵĴ������Ϣ---"<<endl;
	for (int i = 0; i < index; i++) {
		cout << "����"+arrRecord[i].time + "  " << "��/ȡ��"<<arrRecord[i].amount <<endl;
	}
	cout << "��ǰʣ���" << balance << endl;
}
int main() {
	Bank bank(123456, "2020-2-1", 12000);
	for(int i = 0; i<3;i++)
	bank.saveOrTakeMoney();
	bank.showRecord();
	system("pause");
	return 0;
}