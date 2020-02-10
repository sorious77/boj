#include <iostream>

using namespace std;

int arr[100];

int main() {
	int x;
	cin >> x;

	int num = 0;

	for (int i = 0;; i++) {
		arr[i] = x % 2;
		x /= 2;

		if (x == 0)
			break;
	}

	int cnt = 0;
	for (int i = 0; i < sizeof(arr); i++) {
		if (arr[i] == 1)
			cnt++;
	}
	cout << cnt;
}