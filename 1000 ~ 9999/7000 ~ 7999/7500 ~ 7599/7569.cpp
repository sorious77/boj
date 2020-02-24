#include <iostream>
#include <queue>
#include <cstring>

struct location {
	int h;
	int x;
	int y;
};

using namespace std;

int dir[6][3] = { {1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1} };

int box[100][100][100];

queue<location> q;

int M, N, H;
bool change;

bool finish();
void bfs();
bool check_move(int h, int x, int y);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	cin >> M >> N >> H;

	location temp;

	for (int i = 0; i < H; i++) { // 높이
		for (int j = 0; j < N; j++) { // 세로
			for (int k = 0; k < M; k++) { // 가로
				cin >> box[i][j][k];

				if (box[i][j][k] == 1) {
					temp.x = k;	temp.y = j;	temp.h = i;
					q.push(temp);
				}
			}
		}
	}

	bfs();
}

bool finish() {
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (box[i][j][k] == 0)
					return false;
			}
		}
	}
	return true;
}

void bfs() {
	int curSize = q.size();
	location temp;
	int day = 0;

	while (!q.empty()) {
		if (finish()) {
			change = true;
			break;
		}

		change = false;

		for (int i = 0; i < curSize; i++) {
			int curX = q.front().x;
			int curY = q.front().y;
			int curH = q.front().h;

			q.pop();

			for (int j = 0; j < 6; j++) {
				int nextX = curX + dir[j][0];
				int nextY = curY + dir[j][1];
				int nextH = curH + dir[j][2];

				if (check_move(nextH, nextX, nextY) && box[nextH][nextY][nextX] == 0) {
					box[nextH][nextY][nextX] = 1;
					temp.h = nextH;	temp.x = nextX;	temp.y = nextY;
					q.push(temp);
					change = true;
				}
			}
		}

		curSize = q.size();
		day++;
	}

	if (!change)
		cout << -1 << "\n";
	else
		cout << day << "\n";
}

bool check_move(int h, int x, int y) {
	if (0 <= h && h < H && 0 <= x && x < M && 0 <= y && y < N)
		return true;

	return false;
}