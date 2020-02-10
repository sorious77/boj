#include <iostream>
#include <queue>

#define MAX_SIZE 50

using namespace std;

queue<pair<int, int>> q;

int dir[4][2] = { {1,0}, {-1,0}, {0,1},{0,-1} };
int field[MAX_SIZE][MAX_SIZE];
bool visit[MAX_SIZE][MAX_SIZE];

int T, M, N, K;

void bfs(int x, int y);

int main() {
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> M >> N >> K;

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				field[j][k] = 0;
				visit[j][k] = false;
			}
		}

		for (int j = 0; j < K; j++) {
			int x, y;
			cin >> x >> y;

			field[y][x] = 1;
		}

		int count = 0;

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (!visit[j][k] && field[j][k] == 1) {
					bfs(k, j);
					count++;
				}
			}
		}

		cout << count << endl;
	}
}

void bfs(int x, int y) {
	visit[y][x] = true;
	q.push(make_pair(x, y));

	while (!q.empty()) {
		int curX = q.front().first;
		int curY = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dir[i][0];
			int nextY = curY + dir[i][1];

			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
				if (field[nextY][nextX] == 1 && !visit[nextY][nextX]) {
					visit[nextY][nextX] = true;
					q.push(make_pair(nextX, nextY));
				}
			}
		}
	}
}