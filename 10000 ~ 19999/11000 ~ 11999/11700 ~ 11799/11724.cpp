#include <iostream>
#include <queue>

using namespace std;

void bfs(int n);

vector<int> v[1001];
bool visit[1001] = { false, };

int N, M;

int main() {
	int res = 0;

	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int start, end;

		cin >> start >> end;

		v[start].push_back(end);
		v[end].push_back(start);
	}

	for (int i = 1; i <= N; i++) {
		if (!visit[i]) {
			res++;
			bfs(i);
		}
	}

	cout << res;

	return 0;
}

void bfs(int n) {
	queue<int> q;
	q.push(n);
	visit[n] = true;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			if (!visit[v[cur][i]]) {
				visit[v[cur][i]] = true;
				q.push(v[cur][i]);
			}
		}
	}
}