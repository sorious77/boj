#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
using ll = long long;

bool compare(pair<ll, int> a, pair<ll, int> b);

int main() {
	vector<pair<ll, int>> v;

	int N, i, j;
	cin >> N;

	for (i = 0; i < N; i++) {
		ll input;
		cin >> input;

		for (j = 0; j < v.size(); j++) {
			if (v[j].first == input) {
				v[j].second++;
				break;
			}
		}

		if (j == v.size())
			v.push_back(make_pair(input, 1));
	}

	sort(v.begin(), v.end(), compare);

	printf("%lld\n", v[0].first);
}

bool compare(pair<ll, int> a, pair<ll, int> b) {
	if (a.second == b.second)
		return a.first < b.first;
	else
		return a.second > b.second;
}