#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int N, M;

void dfs(int x, int y, int count, int sum);
void shape(int x, int y);
void initVisit();

int dir[4][2] = { {0,-1}, {0,1}, {-1,0}, {1,0} };

bool visit[500][500];
int board[500][500];
int Max = -1;

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			memset(visit, false, sizeof(visit));
			visit[i][j] = true; // visit x,y -> true

			dfs(j, i, 0, board[i][j]); // j : x, i : y

			shape(j, i);
		}
	}

	cout << Max;
}

void dfs(int x, int y, int count, int sum) {
	if (count >= 3) {
		if (Max < sum) {
			Max = sum;
		}
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nextX = x + dir[i][0];
		int nextY = y + dir[i][1];

		if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
			if (visit[nextY][nextX] == false) {
				visit[nextY][nextX] = true;
				dfs(nextX, nextY, count + 1, sum + board[nextY][nextX]);
				visit[nextY][nextX] = false;
			}
		}
	}
}

void shape(int x, int y) {
	int sum;

	if (y - 1 >= 0 && y + 1 < N && x + 1 < M) { // ㅏ 모양
		sum = board[y][x] + board[y - 1][x] + board[y + 1][x] + board[y][x + 1];
		if (sum > Max)
			Max = sum;
	}

	if (y - 1 >= 0 && x - 1 >= 0 && y + 1 < N) { // ㅓ 모양
		sum = board[y][x] + board[y - 1][x] + board[y + 1][x] + board[y][x - 1];
		if (sum > Max)
			Max = sum;
	}

	if (y - 1 >= 0 && x - 1 >= 0 && x + 1 < M) { // ㅗ 모양
		sum = board[y][x] + board[y - 1][x] + board[y][x - 1] + board[y][x + 1];
		if (sum > Max)
			Max = sum;
	}

	if (y + 1 < N && x - 1 >= 0 && x + 1 < M) { // ㅜ 모양
		sum = board[y][x] + board[y][x - 1] + board[y][x + 1] + board[y + 1][x];
		if (sum > Max)
			Max = sum;
	}
}

void initVisit() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
			visit[i][j] = false;
	}
}