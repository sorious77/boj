#include <iostream>
#include <algorithm>

using namespace std;

int solve();

int N;
int two[501] = { 0, };
int five[501] = { 0, };

int main() {
	cin >> N;

	cout << solve();

	return 0;
}

int solve() {
	int twoCount = 0;
	int fiveCount = 0;

	for (int i = 1; i <= N; i++) {
		if (i % 2 == 0) {
			two[i] = two[i / 2] + 1;
			twoCount += two[i];
		}
		if (i % 5 == 0) {
			five[i] = five[i / 5] + 1;
			fiveCount += five[i];
		}
	}

	return min(twoCount, fiveCount);
}