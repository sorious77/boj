#include <iostream>
#include <queue>
#include <cstring>

#define UP 0
#define DOWN 1
#define RIGHT 2
#define LEFT 3

#define APPLE -1
#define SNAKE 1

using namespace std;

int Dir[4][2] = { {-1,0}, {1,0},{0,1}, {0,-1} }; // 위, 아래, 오른쪽, 왼쪽

int board_size; // board size
queue<pair<int, char>> snake_move; // 뱀의 움직임
queue<pair<int, int>> snake;

int cur_dir; // 현재 뱀의 방향

int set_direction(int cur, char next); // 다음에 움직일 방향

int main() {
	int count = 0;

	cin >> board_size;

	// make board and initialize
	int **board = new int*[board_size];
	for (int i = 0; i < board_size; i++) {
		board[i] = new int[board_size];
		memset(board[i], 0, board_size * sizeof(int));
	}

	// input apple location
	int num, col, row;
	cin >> num;

	for (int i = 0; i < num; i++) {
		cin >> col >> row;
		board[col - 1][row - 1] = APPLE; // -> array start position : 0, 0
	}

	cin >> num;

	int sec;
	char direction;

	cur_dir = RIGHT;

	for (int i = 0; i < num; i++) {
		cin >> sec;
		cin >> direction;
		
		snake_move.push(make_pair(sec, direction));
	}

	int next_dir;
	int curX = 0, curY = 0;
	int nextX, nextY;
	bool check_end = false;

	board[curX][curY] = SNAKE; // 뱀의 처음 위치
	snake.push(make_pair(curX, curY));

	while (!check_end) { // 뱀이 죽지 않는 동안 while문 반복
		if (!snake_move.empty()) {
			sec = snake_move.front().first; // 현재 방향으로 가는 시간
			next_dir = set_direction(cur_dir, snake_move.front().second); // 다음에 움직일 방향

			snake_move.pop();
		}
		
		while (true) {
			count++;

			nextX = curX + Dir[cur_dir][0];	nextY = curY + Dir[cur_dir][1]; // 뱀의 머리 위치

			// 벽에 닿을 경우
			if (nextX == -1 || nextX == board_size || nextY == -1 || nextY == board_size) {
				check_end = true;
				break;
			}
			
			//자기 몸에 닿을 경우
			if (board[nextX][nextY] == SNAKE) {
				check_end = true;
				break;
			}

			// 사과를 먹지 않을 경우
			if (board[nextX][nextY] != APPLE) {
				board[snake.front().first][snake.front().second] = 0;
				snake.pop();
			}

			board[nextX][nextY] = SNAKE;
			snake.push(make_pair(nextX, nextY));
			curX = nextX;	curY = nextY;

			if (count == sec)
				break;
		}
		cur_dir = next_dir;
	}

	cout << count << endl;
}

int set_direction(int cur, char next) {
	switch (cur) {
	case UP:
		if (next == 'L')
			return LEFT;
		if (next == 'D')
			return RIGHT;
	case RIGHT:
		if (next == 'L')
			return UP;
		if (next == 'D')
			return DOWN;
	case LEFT:
		if (next == 'L')
			return DOWN;
		if (next == 'D')
			return UP;
	case DOWN:
		if (next == 'L')
			return RIGHT;
		if (next == 'D')
			return LEFT;
	}
}