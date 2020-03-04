#include <iostream>

using namespace std;

int findLCM(int a, int b);

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		int M, N, x, y;

		cin >> M >> N >> x >> y;

		int temp = x;
		int lcm = findLCM(M, N);

		for (;; temp += M) {
			if ((temp - 1) % N + 1 == y || temp > lcm)
				break;
		}

		if (temp <= lcm)
			cout << temp << "\n";
		else
			cout << -1 << "\n";
	}

	return 0;
}

int findLCM(int a, int b) {
	int tempA = a;
	int tempB = b;

	while (b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}

	return tempA * tempB / a;
}