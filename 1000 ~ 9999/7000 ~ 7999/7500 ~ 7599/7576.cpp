#include <iostream>
#include <queue>

using namespace std;

int dir[4][2] = { {-1,0}, {1,0}, {0,-1}, {0,1} };

int M, N;
int box[1000][1000];
int visit[1000][1000];
queue<pair<int, int>> q;

void bfs();
bool check();

int main() {
	cin >> M >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> box[i][j];
			visit[i][j] = 0;
			if (box[i][j] == 1) {
				q.push(make_pair(j, i));
			}
		}
	}

	bfs();
}

void bfs() {
	bool ripe = false;
	int max = 0;

	while (!q.empty()) { // 모두 익거나 q가 비면 종료
		int curX = q.front().first, curY = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dir[i][0];
			int nextY = curY + dir[i][1];

			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
				if (box[nextY][nextX] == 0) {
					box[nextY][nextX] = 1;
					visit[nextY][nextX] = visit[curY][curX] + 1;
					q.push(make_pair(nextX, nextY));

					if (visit[nextY][nextX] > max)
						max = visit[nextY][nextX];
				}
			}
		}
	}

	ripe = check();

	if (ripe)
		cout << max;
	else
		cout << -1;
}

bool check() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (box[i][j] == 0)
				return false;
		}
	}

	return true;
}