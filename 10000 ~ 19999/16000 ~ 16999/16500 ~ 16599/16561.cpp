#include <iostream>

using namespace std;

int main() {
	int n;

	cin >> n;

	int count = 0;
	int sum = 0;

	for (int i = 1; i < n / 3; i++) {
		sum = i * 3;

		for (int j = 1; j < n / 3; j++) {
			int tempSum = sum + j * 3;

			if (n - tempSum >= 3) {
				count++;
			}
		}
	}

	cout << count;

	return 0;
}