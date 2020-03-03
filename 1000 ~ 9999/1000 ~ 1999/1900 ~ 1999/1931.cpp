#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b);

int N;

vector<pair<int, int>> v;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);

	cin >> N;
	
	int start, end;
	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		v.push_back(make_pair(start, end));
	}
	
	sort(v.begin(), v.end(), compare);

	int count = 0;
	int next = 0;

	for (int i = 0; i < N; i++) {
		if (next <= v[i].first) {
			next = v[i].second;
			count++;
		}
	}

	cout << count;

	return 0;
}

bool compare(pair<int, int> a, pair<int, int> b) {
	if(a.second == b.second)
		return a.first < b.first;
	else
		return a.second < b.second;
}