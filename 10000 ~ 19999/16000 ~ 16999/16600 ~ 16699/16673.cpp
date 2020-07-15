#include <iostream>

using namespace std;

int main() {
	int c, k, p;

	cin >> c >> k >> p;

	int sum = 0;

	for (int i = 1; i <= c; i++) {
		sum += k * i + p * i * i;
	}

	cout << sum;

	return 0;
}