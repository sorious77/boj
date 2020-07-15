#include <iostream>
#include <string>

using namespace std;

struct person {
	string name;
	int year;
	int month;
	int day;
};

person input();
person findOld(person a, person b);
person findYoung(person a, person b);

int main() {
	int n;

	cin >> n;

	person old, young;

	old = input();
	young = old;

	for (int i = 1; i < n; i++) {
		person temp = input();

		old = findOld(old, temp);
		young = findYoung(young, temp);
	}

	cout << young.name << "\n" << old.name;
}

person input() {
	person temp;

	cin >> temp.name >> temp.day >> temp.month >> temp.year;

	return temp;
}

person findOld(person a, person b) {
	if (a.year == b.year) {
		if (a.month == b.month) {
			return a.day < b.day ? a : b;
		}
		else
			return a.month < b.month ? a : b;
	}
	else
		return a.year < b.year ? a : b;
}

person findYoung(person a, person b) {
	if (a.year == b.year) {
		if (a.month == b.month) {
			return a.day > b.day ? a : b;
		}
		else
			return a.month > b.month ? a : b;
	}
	else
		return a.year > b.year ? a : b;
}