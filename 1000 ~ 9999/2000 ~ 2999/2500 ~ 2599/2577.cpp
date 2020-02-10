#include <iostream>

using namespace std;

int length(int num);

int main() {
	int a, b, c;
	int mul, arr[10] = { 0, };

	cin >> a >> b >> c;

	mul = a * b * c;

	int div = 1, len;

	len = length(mul);

	for (int i = 0; i < len; i++) {
		arr[mul / div % 10]++;

		div *= 10;
	}

	for (int i = 0; i < 10; i++) {
		cout << arr[i] << endl;
	}
}

int length(int num) {
	int div = 1;
	int i = 0;
	while (num / div > 0) {
		i++;
		div *= 10;
	}

	return i;
}