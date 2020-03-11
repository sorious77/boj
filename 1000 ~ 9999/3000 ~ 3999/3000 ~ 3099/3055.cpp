#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int dir[4][2] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
char map[51][51];
int R, C;
queue<pair<int, int>> water;
queue<pair<int, int>> dochi;

void bfs();
void input();

int main() {
	input();

	bfs();

	return 0;
}

void input() {
	cin >> R >> C;

	for (int i = 0; i < R; i++) {
		cin >> map[i];
		for (int j = 0; j < C; j++) {
			if (map[i][j] == '*')
				water.push(make_pair(j, i));
			else if (map[i][j] == 'S')
				dochi.push(make_pair(j, i));
		}
	}
}

void bfs() {
	int curX, curY;
	int nextX, nextY;
	int size, count = 0;
	bool check, finish = false;
	bool water_visit[51][51] = { false, };
	bool visit[51][51] = { false, };

	while (true) {
		check = false;

		size = water.size();

		for (int i = 0; i < size; i++) {
			curX = water.front().first;
			curY = water.front().second;
			water_visit[curY][curX] = true;
			water.pop();

			for (int j = 0; j < 4; j++) {
				nextX = curX + dir[j][0];
				nextY = curY + dir[j][1];

				if (0 <= nextX && nextX < C && 0 <= nextY && nextY < R) {
					if (map[nextY][nextX] != 'D' && map[nextY][nextX] != 'X' && !water_visit[nextY][nextX]) {
						map[nextY][nextX] = '*';
						water.push(make_pair(nextX, nextY));
						water_visit[nextY][nextX] = true;
					}
				}
			}
		}

		size = dochi.size();

		for (int i = 0; i < size; i++) {
			curX = dochi.front().first;
			curY = dochi.front().second;
			dochi.pop();
			visit[curY][curX] = true;

			if (map[curY][curX] == 'D') {
				finish = true;
				break;
			}

			for (int j = 0; j < 4; j++) {
				nextX = curX + dir[j][0];
				nextY = curY + dir[j][1];

				if (0 <= nextX && nextX < C && 0 <= nextY && nextY < R) {
					if (map[nextY][nextX] != '*' && map[nextY][nextX] != 'X' && !visit[nextY][nextX]) {
						dochi.push(make_pair(nextX, nextY));
						check = true;
						visit[nextY][nextX] = true;
					}
				}
			}
		}

		if (finish) {
			cout << count << "\n";
			break;
		}

		if (!check) {
			cout << "KAKTUS" << "\n";
			break;
		}
		count++;
	}
	
}