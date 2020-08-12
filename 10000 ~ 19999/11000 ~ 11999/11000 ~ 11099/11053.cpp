#include <iostream>
#include <vector>

using namespace std;

void solve();
vector<int> input(int *n);

int main() {
	solve();

	return 0;
}

void solve() {
	int n, ans = 1;
	vector<int> num;
	
	num = input(&n);

	vector<int> dp(n, 1);

	dp[0] = 1;
	
	for (int i = 1; i < n; i++) {
		int temp = 0;

		for (int j = 0; j < i; j++) {
			if (num[i] > num[j]) {
				temp = temp > dp[j] ? temp : dp[j];
			}
		}

		dp[i] = temp + 1;

		if (dp[i] > ans) {
			ans = dp[i];
		}
	}

	cout << ans;
}

vector<int> input(int *n) {
	cin >> *n;

	vector<int> num;
	int temp;

	for (int i = 0; i < *n; i++) {
		cin >> temp;
		num.push_back(temp);
	}

	return num;
}
