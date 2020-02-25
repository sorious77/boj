#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int findGCD(int num1, int num2) {
	if (num1 < num2)
		swap(num1, num2);

	if (num2 == 0)
		return num1;

	return findGCD(num2, num1 % num2);
}

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		int n, input;

		cin >> n;
		vector<int> num;
		long long sum = 0;

		for (int i = 0; i < n; i++) {
			cin >> input;

			num.push_back(input);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum += findGCD(num[i], num[j]);
			}
		}

		cout << sum << "\n";
	}

	return 0;
}