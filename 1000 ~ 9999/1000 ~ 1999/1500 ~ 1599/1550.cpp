#include <iostream>
#include <cmath>
#include <cstring>

using namespace std;

int findNum(char c);

int main() {
	char input[7];

	scanf("%s", input);

	int sum = 0;
	int len = strlen(input);

	for (int i = 0; i < len; i++) {
		sum += findNum(input[i]) * pow(16, len - i - 1);
	}

	cout << sum;
}

int findNum(char c) {
	if ('0' <= c && c <= '9')
		return c - '0';
	else
		return c - 'A' + 10;
}