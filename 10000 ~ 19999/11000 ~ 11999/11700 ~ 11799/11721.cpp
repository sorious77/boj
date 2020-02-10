#include <iostream>

using namespace std;

int main() {
	char str[100];

	cin >> str;

	for (int i = 0; i < 100; i++) {
		if (str[i] == '\0')
			break;
		cout << str[i];
		if (i % 10 == 9)
			cout << endl;
	}
}