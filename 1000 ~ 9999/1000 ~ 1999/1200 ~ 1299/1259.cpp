#include <iostream>
#include <string>

using namespace std;

bool check(string str);

int main() {
	string input;
	
	while (true) {
		cin >> input;
		if (input == "0")
			break;

		if (check(input))
			cout << "yes" << endl;
		else
			cout << "no" << endl;
	}
}

bool check(string str) {
	int len = str.length();
	for (int i = 0; i < len / 2; i++) {
		if (str[i] != str[len - i - 1])
			return false;
	}
	return true;
}