#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

void inputData();
int bfs(int num);

bool visit[100001] = { false, };
vector<pair<int, int>> graph[100001];
int maxLen = -1;

int main() {
	inputData();

	int x = bfs(1); // 정점 1에서 최대 거리에 위치한 정점
	bfs(x); // 해당 정점에서 가장 먼 거리에 위치한 정점을 구하면, 그 거리가 트리의 지름이 됨

	cout << maxLen;

	return 0;
}

void inputData() {
	int n;
	cin >> n;

	int num, vertex, len;
	for (int i = 1; i <= n; i++) {
		cin >> num;

		while (true) {
			cin >> vertex;

			if (vertex == -1) {
				break;
			}
			cin >> len;

			graph[num].push_back(make_pair(vertex, len));
		}
	}
}

int bfs(int num) {
	fill(visit, visit + 100001, false);

	visit[num] = true;
	queue<pair<int, int>> q;

	int maxIndex;

	q.push(make_pair(num, 0));
	maxLen = 0;

	while (!q.empty()) {
		int currVer = q.front().first;
		int curDist = q.front().second;
		q.pop();

		for (int i = 0; i < graph[currVer].size(); i++) {
			int vertex = graph[currVer][i].first;
			int len = graph[currVer][i].second;
			
			if (!visit[vertex]) {
				visit[vertex] = true;
				q.push(make_pair(vertex, curDist + len));

				if (curDist + len > maxLen) {
					maxLen = curDist + len;
					maxIndex = vertex;
				}
			}
		}
	}

	return maxIndex;
}