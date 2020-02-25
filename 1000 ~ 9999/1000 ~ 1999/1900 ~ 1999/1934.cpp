#include <iostream>
#include <algorithm>

using namespace std;

int findGCD(int num1, int num2) {
	if (num1 < num2)
		swap(num1, num2);

	if (num2 == 0)
		return num1;

	return findGCD(num2, num1 % num2);
}

int main() {
	int num1, num2;
	int test_case;
	int gcd;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		cin >> num1 >> num2;

		gcd = findGCD(num1, num2);

		cout << num1 * num2 / gcd << "\n";
	}

	return 0;
}