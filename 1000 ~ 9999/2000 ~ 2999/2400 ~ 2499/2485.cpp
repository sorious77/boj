#include <iostream>
#include <vector>

using namespace std;

void solve();
int findGCD(int a, int b);

int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	solve();

	return 0;
}

void solve() {
	int n;
	vector<int> v;

	cin >> n;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;

		v.push_back(num);
	}

	int gcd = findGCD(v[1] - v[0], v[2] - v[1]);

	for (int i = 2; i < n - 1; i++) {
		gcd = findGCD(gcd, v[i + 1] - v[i]);
	}

	int ans = ((v[n - 1] - v[0]) / gcd) - n + 1;

	cout << ans;
}

int findGCD(int a, int b) {
	while (b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}
	return a;
}