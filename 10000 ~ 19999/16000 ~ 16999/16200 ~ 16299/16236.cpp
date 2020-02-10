#include <iostream>
#include <queue>
#include <algorithm>

#define INF 999999

using namespace std;

int dir[4][2] = { {-1,0},{1,0},{0,1},{0,-1} };

int N;
int board[20][20];
int distArr[20][20];
int shark = 2;
int feed = 0;
int sharkX, sharkY;
int time = 0;

void bfs();

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];

			if (board[i][j] == 9) {
				sharkX = j;
				sharkY = i;
			}
		}
	}

	bfs();

	cout << time;
}

void bfs() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			distArr[i][j] = -1;
		}
	}
	
	distArr[sharkY][sharkX] = 0;

	queue <pair<int, int>> q;
	q.push(make_pair(sharkY, sharkX));

	while (!q.empty()) {
		int x = q.front().second;
		int y = q.front().first;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if(distArr[nextY][nextX] == -1 && shark >= board[nextY][nextX]){
					distArr[nextY][nextX] = distArr[y][x] + 1;
					q.push(make_pair(nextY, nextX));
				}
			}
		}
	}

	int min = INF;
	int x, y;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (shark > board[i][j] && board[i][j] != 0 && distArr[i][j] > 0) { // 상어보다 작은 물고기
				if (min > distArr[i][j]) {
					min = distArr[i][j];
					x = j;	y = i;
				}
			}
		}
	}

	if (min == INF)
		return;

	board[sharkY][sharkX] = 0; // 상어 이동
	sharkX = x;	sharkY = y; // 상어 이동
	board[y][x] = 9; // 상어 이동
	feed++; // 먹이 수 + 1

	if (feed == shark) { // 상어의 크기만큼 먹이를 먹었을 경우
		feed = 0;
		shark++;
	}

	time += min;

	bfs();
}