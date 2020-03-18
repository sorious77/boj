#include <iostream>
#include <string>
#include <queue>
#include <cmath>

using namespace std;

int N, T, G;

void input();
int solve();

queue<pair<int, int>> q; // 현재 숫자, 횟수
bool visit[100000] = { false, };

int main() {

	int res = solve();

	if (res == -1)
		cout << "ANG\n";
	else
		cout << res << "\n";

	return 0;
}

void input() {
	cin >> N >> T >> G;

	visit[N] = true;
	q.push(make_pair(N, 0));
}

int solve() {
	input();

	while (!q.empty()) {
		int cur = q.front().first;
		int count = q.front().second;
		q.pop();

		if (count > T)
			continue;

		if (cur == G)
			return count;

		if (cur + 1 <= 99999 && !visit[cur+1]) {
			q.push(make_pair(cur + 1, count + 1));
			visit[cur + 1] = true;
		}

		if (cur * 2 <= 99999) {
			int minus = pow(10, (int)log10(cur * 2));
			int next = cur * 2 - minus;
			if (!visit[next]) {
				q.push(make_pair(next, count + 1));
				visit[next] = true;
			}
		}
	}

	return -1;
}