#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> v;
	int input;
	for (int i = 0; i < n; i++) {
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end());

	int ans = -1;

	do {
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += abs(v[i] - v[i + 1]);
		}
		if (sum > ans)
			ans = sum;
	} while (next_permutation(v.begin(), v.end()));

	cout << ans << "\n";

	return 0;
}