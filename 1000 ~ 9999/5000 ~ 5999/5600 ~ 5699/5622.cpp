#include <iostream>
#include <cstring>

using namespace std;

int find(char c);

int main() {
	char input[16];

	cin >> input;

	int res = 0;

	for (int i = 0; i < strlen(input); i++) {
		res += find(input[i]);
	}
	cout << res;
}

int find(char c) {
	switch (c) {
	case 'A':
	case 'B':
	case 'C':
		return 3;
	case 'D':
	case 'E':
	case 'F':
		return 4;
	case 'G':
	case 'H':
	case 'I':
		return 5;
	case 'J':
	case 'K':
	case 'L':
		return 6;
	case 'M':
	case 'N':
	case 'O':
		return 7;
	case 'P':
	case 'Q':
	case 'R':
	case 'S':
		return 8;
	case 'T':
	case 'U':
	case 'V':
		return 9;
	default:
		return 10;
	}
}