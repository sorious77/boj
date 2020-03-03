#include <iostream>
#include <algorithm>
#include <vector>

using ll = long long;
using namespace std;

vector<ll> v;
vector<ll> sum;

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		v.push_back(input);
	}

	sort(v.begin(), v.end());
	
	ll ans = v[0];
	sum.push_back(v[0]);

	for (int i = 1; i < n; i++) {
		sum.push_back(sum[i-1] + v[i]);
		ans += sum[i];
	}

	cout << ans;
}