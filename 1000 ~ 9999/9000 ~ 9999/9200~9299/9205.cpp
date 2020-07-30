#include <iostream>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

int T, N; // 테스트케이스의 개수, 편의점의 개수
vector<pair<int, int>> v;

void solve();
bool bfs();

int main(){
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	
	solve();

	return 0;
}

void solve() {
	cin >> T;

	while (T--) {
		v.clear();

		cin >> N;

		int x, y;

		for (int i = 0; i < N + 2; i++) {
			cin >> x >> y;
			v.push_back(make_pair(x, y));
		}

		if (bfs()) {
			cout << "happy\n";
		}
		else {
			cout << "sad\n";
		}
	}


}

bool bfs() {
	bool visit[102] = { false, };

	queue<pair<int, int>> q;

	q.push(make_pair(v[0].first, v[0].second));
	visit[0] = true;

	while (!q.empty()) {
		int curX = q.front().first;
		int curY = q.front().second;
		q.pop();

		if (curX == v[v.size() - 1].first && curY == v[v.size() - 1].second) {
			return true;
		}

		for (int i = 0; i < v.size(); i++) {
			if (!visit[i] && (abs(curX - v[i].first) + abs(curY - v[i].second) <= 1000)) {
				visit[i] = true;
				q.push(make_pair(v[i].first, v[i].second));
			}
		}
	}

	return false;
}