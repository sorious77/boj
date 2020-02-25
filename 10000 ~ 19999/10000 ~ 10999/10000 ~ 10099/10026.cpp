#include <iostream>
#include <queue>

using namespace std;

int RGB_bfs();
int RB_bfs();

int dir[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1} };

char board[101][101];
int N;

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		scanf("%s", board[i]);
	}

	printf("%d %d\n", RGB_bfs(), RB_bfs());

	return 0;
}

int RGB_bfs() {
	bool visit[101][101] = { false, };

	int count = 0;
	queue<pair<int, int>> q;
	char curCh;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visit[i][j]) {
				count++;
				curCh = board[i][j];
				
				q.push(make_pair(j, i));
				visit[i][j] = true;

				while (!q.empty()) {
					int curX = q.front().first;
					int curY = q.front().second;
					q.pop();

					for (int i = 0; i < 4; i++) {
						int nextX = curX + dir[i][0];
						int nextY = curY + dir[i][1];

						if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
							if (curCh == board[nextY][nextX] && !visit[nextY][nextX]) {
								q.push(make_pair(nextX, nextY));
								visit[nextY][nextX] = true;
							}
						}
					}
				}
			}
		}
	}

	return count;
}

int RB_bfs() {
	bool visit[101][101] = { false, };
	int count = 0;
	char curCh;
	queue<pair<int, int>> q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visit[i][j]) {
				count++;
				curCh = board[i][j];

				q.push(make_pair(j, i));
				visit[i][j] = true;

				while (!q.empty()) {
					int curX = q.front().first;
					int curY = q.front().second;
					q.pop();

					for (int i = 0; i < 4; i++) {
						int nextX = curX + dir[i][0];
						int nextY = curY + dir[i][1];

						if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
							if (!visit[nextY][nextX]) {
								switch (curCh) {
								case 'R':
								case 'G':
									if (board[nextY][nextX] == 'R' || board[nextY][nextX] == 'G'){
										q.push(make_pair(nextX, nextY));
										visit[nextY][nextX] = true;
									}
								break;

								case 'B':
									if (curCh == board[nextY][nextX]) {
										q.push(make_pair(nextX, nextY));
										visit[nextY][nextX] = true;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	return count;
}