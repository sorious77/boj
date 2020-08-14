#include <iostream>

using namespace std;
using ll = long long;

void solve();

int main() {
	solve();

	return 0;
}

void solve() {
	int n;
	cin >> n;

	ll ans = 0;
	pair<ll, ll> dp[91]; // 각각 끝이 0과 1인 N자리 이친수의 개수

	dp[1].first = 0;
	dp[1].second = 1;
	
	for (int i = 2; i <= n; i++) {
		dp[i].first = dp[i - 1].first + dp[i-1].second;
		dp[i].second = dp[i-1].first;
	}

	cout << dp[n].first + dp[n].second;
} 