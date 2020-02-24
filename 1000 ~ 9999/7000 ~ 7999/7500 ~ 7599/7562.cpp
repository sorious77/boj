#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int N;
int x, y; // 처음 위치
int gx, gy; // goal X, goal Y

int visit[300][300] = { 0, };
int dir[8][2] = { {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1} };

void bfs();

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		cin >> N;

		cin >> x >> y >> gx >> gy;

		bfs();

		cout << visit[gy][gx] << "\n";
		memset(visit, 0, sizeof(visit));
	}
}

void bfs() {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));

	while (!q.empty()) {
		int curX = q.front().first;
		int curY = q.front().second;

		if (curX == gx && curY == gy)
			break;

		q.pop();

		for (int i = 0; i < 8; i++) {
			int nextX = curX + dir[i][0];
			int nextY = curY + dir[i][1];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if (visit[nextY][nextX] == 0) {
					visit[nextY][nextX] = visit[curY][curX] + 1;
					q.push(make_pair(nextX, nextY));
				}
			}
		}
	}
}