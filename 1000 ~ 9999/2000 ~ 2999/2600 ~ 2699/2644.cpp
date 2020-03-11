#include <iostream>
#include <queue>

using namespace std;

vector<int> people[101];
int parent[101] = { 0, };
int visit[101] = { 0, };

void bfs(int p1, int p2);

int main() {
	int N, M;
	int p1, p2;
	
	cin >> N >> p1 >> p2 >> M;

	int input1, input2;
	for (int i = 0; i < M; i++) {
		cin >> input1 >> input2;

		people[input1].push_back(input2);
		parent[input2] = input1;
	}

	bfs(p1, p2);

	return 0;
}

void bfs(int p1, int p2) {
	queue<int> q;
	q.push(p2);
	visit[p2] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		if (cur == p1) {
			cout << visit[cur] << "\n";
			return;
		}

		if (parent[cur] != 0 && visit[parent[cur]] == 0) {
			q.push(parent[cur]);
			visit[parent[cur]] = visit[cur] + 1;
		}
		
		for (int i = 0; i < people[cur].size(); i++) {
			if (visit[people[cur][i]] == 0) {
				q.push(people[cur][i]);
				visit[people[cur][i]] = visit[cur] + 1;
			}
		}
	}

	cout << -1 << "\n";
	return;
}