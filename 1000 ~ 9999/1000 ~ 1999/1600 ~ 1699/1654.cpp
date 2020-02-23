#include <iostream>
#include <vector>
#include <climits>

using namespace std;
using ll = long long;

int main() {
	vector<ll> v;

	int K, N;

	cin >> K >> N;

	ll input;

	for (int i = 0; i < K; i++) {
		cin >> input;
		v.push_back(input);
	}

	ll left = 0;
	ll right = LLONG_MAX;
	ll max = 0;

	while (left <= right) {
		ll mid = (left + right) / 2;

		int count = 0;

		for (int i = 0; i < K; i++) {
			count += v[i] / mid;
		}

		if (count >= N) {
			left = mid + 1;
			if (max < mid) {
				max = mid;
			}
		}
		else
			right = mid - 1;
	}

	cout << max;
}