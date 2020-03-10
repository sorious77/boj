#include <iostream>

using namespace std;

int N;
int T[16];
int P[16];

int res = 0;

void dfs(int day, int money);

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> T[i] >> P[i];
	}

	dfs(1, 0);

	cout << res << "\n";

	return 0;
}

void dfs(int day, int money) {
	if (day > N)
		return;

	for (int i = day; i <= N; i++) {
		if (i + T[i] <= N + 1) {
			if (money + P[i] > res)
				res = money + P[i];
			dfs(i + T[i], money + P[i]);
		}
	}
}