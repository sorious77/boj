#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

vector<int> people[101];
int relation[101][101];
int visit[101];

int N, M;

int bfs(int num);

int main() {
	cin >> N >> M;

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		people[a].push_back(b);
		people[b].push_back(a);
	}

	int res;
	int min = 999999;
	int index;

	for (int i = 1; i <= N; i++) {
		res = bfs(i);

		if (res < min) {
			min = res;
			index = i;
		}
	}

	printf("%d\n", index);

	return 0;
}

int bfs(int num) {
	queue<int> q;

	memset(visit, 0, sizeof(visit));

	for (int i = 0; i < people[num].size(); i++) {
		q.push(people[num][i]);
		visit[people[num][i]] = 1;
	}

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < people[cur].size(); i++) {
			int next = people[cur][i];
			if (visit[next] == 0 && next != num) {
				visit[next] = visit[cur] + 1;
				q.push(next);
			}
		}
	}

	int sum = 0;
	for (int i = 1; i <= N; i++) {
		if(i != num)
			sum += visit[i];
	}

	return sum;
}