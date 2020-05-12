#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, C;
vector<int> home;

void input();
void solve();

int main() {
	int n;

	input();

	solve();
}

void input() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	cin >> N >> C;

	int num;
	for (int i = 0; i < N; i++) {
		cin >> num;

		home.push_back(num);
	}

	sort(home.begin(), home.end());
}

void solve() {
	int answer = 1;

	int count = 0;
	int left = home[0];
	int right = home[N - 1] - home[0];
	int mid;
	int prev;

	while (left <= right) {
		prev = 0;
		count = 1; // 시작 점은 항상 true이기 때문

		mid = (left + right) / 2;

		for (int i = 1; i < N; i++) {
			if (home[i] - home[prev] >= mid) {
				count++;
				prev = i;
			}
		}

		if (count >= C) {
			left = mid + 1;
			answer = mid;
		}
		else {
			right = mid - 1;
		}
	}

	cout << answer;
}