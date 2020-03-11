#include <iostream>
#include <queue>

#define SIZE 8

using namespace std;

char board[9][9];
queue<pair<int, int>> q;

int dir[9][2] = { {0,1},{0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}, {0, 0} };

void input();
bool ch_move();
void wall_move();

int main() {
	input();

	q.push(make_pair(0, 7));

	while (true) {
		if (q.size() == 0) {
			cout << 0 << "\n";
			break;
		}
		if (ch_move()) {
			cout << 1 << "\n";
			break;
		}
		wall_move();
	}

	return 0;
}

void input() {
	for (int i = 0; i < SIZE; i++) {
		cin >> board[i];
	}
}

bool ch_move() {
	int qsize = q.size();
	bool visit[SIZE + 1][SIZE + 1] = { false, };

	for (int i = 0; i < qsize; i++) {
		int curX = q.front().first;
		int curY = q.front().second;
		q.pop();

		if (board[curY][curX] == '#')
			continue;

		if (curX == 7 && curY == 0)
			return true;


		for (int j = 0; j < 9; j++) {
			int nextX = curX + dir[j][0];
			int nextY = curY + dir[j][1];

			if (0 <= nextX && nextX < SIZE && 0 <= nextY && nextY < SIZE) {
				if (board[nextY][nextX] != '#' && !visit[nextY][nextX]) {
					q.push(make_pair(nextX, nextY));
					visit[nextY][nextX] = true;
				}
			}
		}
	}

	return false;
}

void wall_move() {
	for (int i = 0; i < SIZE; i++) {
		board[7][i] = '.';
	}

	for (int i = SIZE - 1; i > 0; i--) {
		for (int j = 0; j < SIZE; j++) {
			if (board[i - 1][j] == '#') {
				board[i][j] = '#';
				board[i - 1][j] = '.';
			}
		}
	}
}