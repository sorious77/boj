#include <iostream>
#include <queue>

#define SIZE 100

using namespace std;

int board[SIZE][SIZE];
int visit[SIZE][SIZE];
int N, M;

int dir[4][2] = { {1,0}, {0,1}, {0,-1}, {-1, 0} }; // right, down, up, left

void bfs();

int main() {
	cin >> N >> M;

	char *input = new char[N + 1];

	for (int i = 0; i < N; i++) {
		cin >> input;
		for (int j = 0; j < M; j++) {
			board[i][j] = input[j] - '0';
			visit[i][j] = 0;
		}
	}

	bfs();
}

void bfs() {
	queue <pair<int, int>> q;

	q.push(make_pair(0, 0));
	visit[0][0] = 1;

	while (!q.empty()) {
		int curX = q.front().first;
		int curY = q.front().second;
		q.pop();

		if (curX == M - 1 && curY == N - 1)
			break;

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dir[i][0];
			int nextY = curY + dir[i][1];

			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
				if (board[nextY][nextX] == 1 && visit[nextY][nextX] == 0) {
					visit[nextY][nextX] = visit[curY][curX] + 1;
					q.push(make_pair(nextX, nextY));
				}
			}
		}
	}

	cout << visit[N - 1][M - 1];
}