#include <iostream>

using namespace std;

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		int sum = 0;
		int arr[4] = { 0, };

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				int temp;
				cin >> temp;
				
				arr[j] += temp;
			}
		}

		if (arr[0] < 1)
			arr[0] = 1;
		if (arr[1] < 1)
			arr[1] = 1;
		if (arr[2] < 0)
			arr[2] = 0;

		sum += arr[0] * 1 + arr[1] * 5 + arr[2] * 2 + arr[3] * 2;

		cout << sum << "\n";
	}
}
