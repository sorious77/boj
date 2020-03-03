#include <iostream>
#include <cmath>

using namespace std;

int num[50001] = { 0, };
int n;

void solve();

int main() {
	cin >> n;

	solve();

	cout << num[n];

	return 0;
}

void solve() {
	for (int i = 1; i <= n; i++) {
		int min = 9999;
		int temp, count;

		if ((int)sqrt(i) * sqrt(i) == i) {
			num[i] = 1;
			continue;
		}

		for (int j = sqrt(i); j >= 1; j--) {
			count = 0;

			temp = num[i - j * j] + 1;
			if (temp < min)
				min = temp;
		}

		num[i] = min;
	}
}