#include <iostream>
#include <algorithm>

using namespace std;

void solve();

int main() {
	solve();

	return 0;
}

void solve() {
	int n;
	cin >> n;

	if (n == 1) {
		cout << 10;
		return;
	}

	int dp[1001][10] = { 0, };
	int ans = 0;

	fill(dp[1], dp[1] + 10, 1);

	for (int i = 2; i <= n; i++) {
		ans = 0;
		for (int j = 0; j <= 9; j++) {
			for (int k = j; k <= 9; k++) {
				dp[i][j] += dp[i - 1][k] % 10007;
			}
			ans += dp[i][j] % 10007;
		}
	}

	cout << ans % 10007;
}