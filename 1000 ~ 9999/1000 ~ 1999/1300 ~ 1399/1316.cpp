#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool check(string s);
bool compare(pair<char, int> a, pair<char, int> b);

int main() {
	int n;

	cin >> n;

	int count = 0;

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;

		if (check(str))
			count++;
	}

	cout << count;
}

bool check(string s) {
	vector<pair<char, int>> v;

	for (int i = 0; i < s.length(); i++) {
		v.push_back(make_pair(s[i], i));
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < v.size() - 1; i++) {
		if (v[i].first == v[i + 1].first) {
			if (v[i].second + 1 != v[i + 1].second)
				return false;
		}
	}

	return true;
}

bool compare(pair<char, int> a, pair<char, int> b) {
	if (a.first == b.first)
		return a.second < b.second;
	else
		return a.first < b.first;
}