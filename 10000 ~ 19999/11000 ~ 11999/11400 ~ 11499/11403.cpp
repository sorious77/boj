#include <iostream>
#include <queue>

using namespace std;

vector<int> v[100];
bool visit[100];

int N;

int bfs(int start, int end);
void initVisit();

int main() {
	cin >> N;

	int num;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> num;

			if (num == 1) {
				v[i].push_back(j);
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d ", bfs(i, j));
		}
		printf("\n");
	}
}

int bfs(int start, int end) {
	initVisit();

	queue<int> q;
	q.push(start);
	visit[start] = true;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			if (v[cur][i] == end)
				return 1;

			if (!visit[v[cur][i]]) {
				visit[v[cur][i]] = true;
				q.push(v[cur][i]);
			}
		}
	}

	return 0;
}

void initVisit() {
	for (int i = 0; i < N; i++) {
		visit[i] = false;
	}
}