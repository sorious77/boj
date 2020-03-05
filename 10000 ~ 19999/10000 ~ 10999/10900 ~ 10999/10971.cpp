#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

int arr[11][11];
vector<int> v;
int ans = INT_MAX;

int main() {
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		v.push_back(i);
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	bool check = false;

	do {
		check = false;
		int sum = 0;

		for (int i = 0; i < v.size() - 1; i++) {
			if (arr[v[i]][v[i + 1]] == 0) {
				check = true;
				break;
			}
			sum += arr[v[i]][v[i + 1]];
		}
		if (!check) {
			if (arr[v[N - 1]][v[0]] != 0) {
				sum += arr[v[N - 1]][v[0]];

				ans = min(sum, ans);
			}
		}
	} while (next_permutation(v.begin(), v.end()));

	cout << ans;
}