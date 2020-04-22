#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int n;

	bool plus[1001] = { false, };
	bool minus[1001] = { false, };

	cin >> n;

	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		if (input < 0) {
			minus[abs(input)] = true;
		}
		else {
			plus[input] = true;
		}
	}

	for (int i = 1000; i > 0; i--) {
		if (minus[i])
			printf("%d ", i * -1);
	}

	for (int i = 0; i <= 1000; i++) {
		if (plus[i])
			printf("%d ", i);
	}

	return 0;
}