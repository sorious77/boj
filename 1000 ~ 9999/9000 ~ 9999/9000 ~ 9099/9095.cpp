#include <iostream>

using namespace std;

void solve();

int arr[11];

int main() {
	int test_case;
	cin >> test_case;

	solve();

	for (int t = 0; t < test_case; t++) {
		int num;
		cin >> num;

		cout << arr[num] << "\n";
	}
}

void solve() {
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 4;

	for (int i = 4; i <= 11; i++) {
		arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
	}
}