#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, V;
bool visit[1001];
vector <int> node[1001];
queue <vector<int>> q;

void initVisit();
void dfs(int num);
void bfs();

int main() {
	cin >> N >> M >> V;

	int start, end;
	for (int i = 0; i < M; i++) {
		cin >> start >> end;

		node[start].push_back(end);
		node[end].push_back(start);
	}

	for (int i = 1; i <= N; i++) {
		sort(node[i].begin(), node[i].end());
	}

	initVisit();
	dfs(V);
	cout << endl;
	bfs();
}

void initVisit() {
	for (int i = 1; i <= N; i++)
		visit[i] = false;
}

void dfs(int num) {
	visit[num] = true;
	printf("%d ", num);

	for (int i = 0; i < node[num].size(); i++) {
		if (!visit[node[num][i]]) {
			dfs(node[num][i]);
		}
	}
}

void bfs() {
	initVisit();

	q.push(node[V]);
	visit[V] = true;
	printf("%d ", V);

	while (!q.empty()) {
		vector<int> temp = q.front();
		q.pop();

		for (int i = 0; i < temp.size(); i++) {
			if (!visit[temp[i]]) {
				visit[temp[i]] = true;
				q.push(node[temp[i]]);
				printf("%d ", temp[i]);
			}
		}
	}
}