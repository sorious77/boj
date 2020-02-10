#include <iostream>
#include <queue>

using namespace std;

int n, m; // board size
int board[50][50]; // 0 : 빈칸, 1 : 벽, -1 : 청소 완료

int dir[4][2] = { {-1,0},{0,1},{1,0},{0,-1} };

void bfs(int x, int y, int d);

int main() {
	cin >> n >> m;
	int x, y;
	int d; // 바라보는 방향, 0 : 북, 1: 동, 2 : 남, 3: 서

	cin >> x >> y >> d;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
		}
	}

	bfs(x, y, d);
}

void bfs(int x, int y, int d) {
	int curD = d;
	int nextD;
	int curX = x, curY = y;
	int nextX, nextY;
	bool check = false;
	int count = 0;

	board[curX][curY] = -1;
	count++;

	while (true) {
		int nextD = curD;
		int i;

		check = false;

		for (i = 0; i < 4; i++) {
			// 다음 방향 설정
			if (nextD == 0)
				nextD = 3;
			else
				nextD--;

			nextX = curX + dir[nextD][0];
			nextY = curY + dir[nextD][1];

			if (board[nextX][nextY] == 0) { // 청소하지 않은 공간 존재
				curX = nextX;	curY = nextY;
				curD = nextD;
				check = true;

				board[curX][curY] = -1;
				count++;
				break;
			}
		}

		if (!check) {
			nextX = curX - dir[curD][0];
			nextY = curY - dir[curD][1];
			if (board[nextX][nextY] == 1) {
				cout << count;
				break;
			}
			else {
				curX -= dir[curD][0];
				curY -= dir[curD][1];

				if (curX < 0 || curY < 0 || curX >= n || curY >= m) {
					cout << count;
					break;
				}
			}
		}
	}
}