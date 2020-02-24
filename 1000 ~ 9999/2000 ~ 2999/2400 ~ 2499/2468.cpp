#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int N;
int board[100][100];
bool visit[100][100];

int dir[4][2] = { {1,0}, {0,1}, {-1,0}, {0,-1} };

int max_height;

int bfs(int height);

int main() {
	cin >> N;

	max_height = -1;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];

			if (max_height < board[i][j])
				max_height = board[i][j];
		}
	}

	int max = 1;

	for (int i = 1; i <= max_height; i++) {
		memset(visit, false, sizeof(visit));
		
		int res = bfs(i);

		if (max < res)
			max = res;
	}

	printf("%d\n", max);

	return 0;
}

int bfs(int height) {
	int count = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (board[j][i] <= height)
				visit[j][i] = true;
			else {
				if (!visit[j][i]) {
					queue<pair<int, int>> q;
					visit[j][i] = true;
					q.push(make_pair(i, j));

					count++;

					while (!q.empty()) {
						int curX = q.front().first;
						int curY = q.front().second;
						q.pop();

						for (int i = 0; i < 4; i++) {
							int nextX = curX + dir[i][0];
							int nextY = curY + dir[i][1];

							if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
								if (!visit[nextY][nextX] && board[nextY][nextX] > height) {
									visit[nextY][nextX] = true;
									q.push(make_pair(nextX, nextY));
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