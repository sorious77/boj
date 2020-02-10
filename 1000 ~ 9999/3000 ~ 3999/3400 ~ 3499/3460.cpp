#include <iostream>

using namespace std;

int sec(int num, int *arr);

int main() {
	int t, n;
	int *arr = new int[999];

	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> n;

		for (int j = 0; j <= sec(n, arr); j++) {
			if (arr[j] == 1)
				printf("%d ", j);
		}
	}
}

int sec(int num, int *arr) {
	for (int i = 0; i < 999; i++) {
		arr[i] = num % 2;
		num /= 2;

		if (num == 0) {
			return i;
		}
	}
}