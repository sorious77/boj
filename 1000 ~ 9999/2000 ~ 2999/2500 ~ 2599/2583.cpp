#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

void bfs(int x, int y);

vector<int> ans;
int N, M, K;
bool board[101][101] = { false, };

int dir[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1} };

int main() {
	cin >> M >> N >> K;

	for (int i = 0; i < K; i++) {
		int x1, x2, y1, y2; // (x1,y1)은 왼쪽 위, (x2,y2)는 오른쪽 아래

		cin >> x1 >> y1 >> x2 >> y2;

		for (int j = y1; j < y2; j++) {
			for (int k = x1; k < x2; k++) {
				board[j][k] = true;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!board[i][j])
				bfs(j, i);
		}
	}

	sort(ans.begin(), ans.end());

	printf("%d\n", ans.size());

	for (int i = 0; i < ans.size(); i++) {
		printf("%d ", ans[i]);
	}

	return 0;
}

void bfs(int x, int y) {
	int count = 1;

	queue<pair<int, int>> q;
	q.push(make_pair(x, y));

	board[y][x] = true;

	while (!q.empty()) {
		int curX = q.front().first;
		int curY = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dir[i][0];
			int nextY = curY + dir[i][1];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
				if (!board[nextY][nextX]) {
					q.push(make_pair(nextX, nextY));
					board[nextY][nextX] = true;
					count++;
				}
			}
		}
	}

	ans.push_back(count);
}