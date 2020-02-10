#include <iostream>

using namespace std;

int check(int year);

int main() {
	int year;

	cin >> year;

	cout << check(year);
}

int check(int year) {
	if (((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0)
		return 1;
	else
		return 0;
}