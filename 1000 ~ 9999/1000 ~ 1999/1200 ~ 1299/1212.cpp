#include <iostream>
#include <string>

using namespace std;

int findNum(char n);

int main() {
	string num;

	cin >> num;

	cout << findNum(num[0]);

	for (int i = 1; i < num.length(); i++)
		printf("%03d", findNum(num[i]));

}

int findNum(char n) {
	int num = n - '0';

	switch (num) {
	case 0:
		return 0;
	case 1:
		return 1;
	case 2:
		return 10;
	case 3:
		return 11;
	case 4:
		return 100;
	case 5:
		return 101;
	case 6:
		return 110;
	case 7:
		return 111;
	}
	return -1;
}