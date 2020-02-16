#include <iostream>
#include <queue>

using namespace std;

int a, b;
int N, M;

// adj list
vector<int> adjList[1001];
int visit[1001] = { 0, };
int parent[1001] = { 0, };

void bfs();

int main() {
	cin >> a >> b >> N >> M;

	for (int i = 0; i < M; i++) {
		int start, end;
		cin >> start >> end;

		adjList[start].push_back(end);
		adjList[end].push_back(start);
	}
	for (int i = 0; i <= N; i++) {
		visit[i] = -1;
		parent[i] = -1;
	}
	bfs();
}

void bfs() {
	queue<int> q;

	q.push(a);
	parent[a] = 0;
	visit[a] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		if (cur == b)
			break;

		for (int i = 0; i < adjList[cur].size(); i++) {
			int next = adjList[cur][i];
			if (visit[next] == -1) {
				q.push(next);
				parent[next] = cur;
				visit[next] = visit[parent[next]] + 1;
			}
		}
	}

	cout << visit[b];
}