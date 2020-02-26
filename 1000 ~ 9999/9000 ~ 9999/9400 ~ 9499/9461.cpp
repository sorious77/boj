#include <iostream>

using namespace std;

long long arr[101];

int main() {
	arr[1] = 1;
	arr[2] = 1;
	arr[3] = 1;
	arr[4] = 2;
	arr[5] = 2;

	for (int i = 6; i <= 100; i++) {
		arr[i] = arr[i - 1] + arr[i - 5];
	}

	int test_case;
	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		int input;
		cin >> input;

		printf("%lld\n", arr[input]);
	}
}