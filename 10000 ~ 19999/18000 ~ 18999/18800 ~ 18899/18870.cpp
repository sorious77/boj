#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N;

	map<int, int> ans;
	vector<int> arr;
	vector<int> copy;

	cin.tie(0);
	ios_base::sync_with_stdio(0);
	
	cin >> N;

	int temp;
	
	for (int i = 0; i < N; i++) {
		cin >> temp;
		arr.push_back(temp);
		copy.push_back(temp);
	}

	sort(copy.begin(), copy.end());

	int cur;

	for (int i = 0; i < N; i++) {
		ans.insert(make_pair(copy[i], 1));

		cur = copy[i];

		while (i + 1 < N) {
			if (cur == copy[i + 1]) {
				i++;
			}
			else
				break;
		}
	}

	int index = 0;

	for (auto it = ans.begin(); it != ans.end(); it++) {
		it->second = index;
		index++;
	}

	for (int i = 0; i < N; i++) {
		auto it = ans.find(arr[i]);
		cout << it -> second << " ";
	}
}