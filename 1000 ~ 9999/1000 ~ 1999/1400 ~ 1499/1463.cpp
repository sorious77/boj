#include <iostream>
#include <algorithm>

using namespace std;

int num[1000001];
int N;

void solve();

int main() {
	cin >> N;

	solve();

	cout << num[N];

	return 0;
}

void solve() {
	num[1] = 0;
	for (int i = 2; i <= N; i++) {
		if (i % 2 == 0 && i % 3 == 0) {
			num[i] = min(min(num[i / 2], num[i / 3]), num[i - 1]) + 1;
		}
		else if (i % 2 == 0) {
			num[i] = min(num[i / 2], num[i - 1]) + 1;
		}
		else if (i % 3 == 0) {
			num[i] = min(num[i / 3], num[i - 1]) + 1;
		}
		else
			num[i] = num[i - 1] + 1;
	}
}