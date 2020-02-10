#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string str;

int main() {
	cin >> str;

	int len = str.length();

	int *c = new int[len];

	for (int i = 0; i < len; i++) {
		c[i] = str[i] - '0';
	}

	sort(c, c + len, greater<int>());

	for (int i = 0; i < len; i++) {
		cout << c[i];
	}
}