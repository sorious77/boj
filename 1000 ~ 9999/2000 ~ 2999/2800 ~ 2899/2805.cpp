#include <iostream>
#include <vector>
#include <climits>

using namespace std;
using ll = long long;

int main() {
	int N;
	ll M;
	vector<int> tree;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;

		tree.push_back(input);
	}

	ll left = 0;
	ll right = LLONG_MAX;

	ll max = 0;

	while (left <= right) {
		ll mid = (left + right) / 2;

		ll ans = 0;

		for (int i = 0; i < N; i++) {
			if(tree[i] - mid > 0)
				ans += tree[i] - mid;
		}

		if (ans >= M) {
			if (max < mid)
				max = mid;

			left = mid + 1;
		}
		else
			right = mid - 1;
	}
	cout << max;
}