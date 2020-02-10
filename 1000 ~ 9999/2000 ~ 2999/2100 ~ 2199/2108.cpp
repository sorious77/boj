#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

bool compare(pair<int, int> a, pair<int, int> b);

int main() {
	int n;
	cin >> n;

	vector<int> v;
	vector<pair<int, int>> freq;

	int sum = 0;

	for (int i = 0; i < n; i++) {
		int num, j;
		cin >> num;

		v.push_back(num);
		sum += num;

		for (j = 0; j < freq.size(); j++) {
			if (freq[j].first == num) {
				freq[j].second++;
				break;
			}
		}

		if(j == freq.size())
			freq.push_back(make_pair(num, 1));
	}

	sort(v.begin(), v.end());
	sort(freq.begin(), freq.end(), compare);
	
	cout << floor((double)sum / n + 0.5) << endl;
	cout << v[n / 2] << endl;
	if (n == 1)
		cout << v[0] << endl;
	else {
		if (freq[0].second == freq[1].second)
			cout << freq[1].first << endl;
		else
			cout << freq[0].first << endl;
	}
	cout << v[n - 1] - v[0] << endl;
}

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second)
		return a.first < b.first;
	else
		return a.second > b.second;
}