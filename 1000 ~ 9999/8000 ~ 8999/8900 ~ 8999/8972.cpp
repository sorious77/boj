#include <iostream>
#include <queue>
#include <string>

using namespace std;

int dir[9][2] = {{-1,1},{0,1},{1,1},{-1,0},{0,0},{1,0},{-1,-1},{0,-1},{1,-1} };

int board[101][101]; // 빈칸 : 0, 종수 로봇 : -1, 미친 로봇 : 1이상
int R, C;

queue<pair<int, int>> robot;
int jongX, jongY;
string op;

void input();
void move();
void print();

int main() {
	input();
	move();

	return 0;
}

void input() {
	cin >> R >> C;
	
	char ch;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> ch;

			if (ch == 'R') {
				robot.push(make_pair(j, i));
				board[i][j] = 1;
			}
			else if (ch == 'I') {
				jongX = j;
				jongY = i;
				board[i][j] = -1;
			}
			else
				board[i][j] = 0;
		}
	}

	cin >> op;
}

void move() {
	vector<pair<int, int>> boom;

	for (int i = 0; i < op.length(); i++) {
		int temp[101][101] = { 0, };

		int nextDir = op[i] - '1';

		jongX += dir[nextDir][0];
		jongY += dir[nextDir][1];

		temp[jongY][jongX] = -1;

		int qSize = robot.size();

		for (int j = 0; j < qSize; j++) {
			int curX = robot.front().first;
			int curY = robot.front().second;
			robot.pop();

			if (board[curY][curX] == 1) {
				int nextX, nextY;

				if (curX > jongX)
					nextX = curX - 1;
				else if (curX < jongX)
					nextX = curX + 1;
				else
					nextX = curX;

				if (curY > jongY)
					nextY = curY - 1;
				else if (curY < jongY)
					nextY = curY + 1;
				else
					nextY = curY;

				if (temp[nextY][nextX] == -1) {
					printf("kraj %d\n", i + 1);
					return;
				}

				temp[nextY][nextX]++;

				if (temp[nextY][nextX] == 1) {
					robot.push(make_pair(nextX, nextY));
				}
				else {
					boom.push_back(make_pair(nextX, nextY));
				}
			}
		}

		for (int j = 0; j < boom.size(); j++) {
			temp[boom[j].second][boom[j].first] = 0;
		}
		boom.clear();

		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				board[j][k] = temp[j][k];
			}
		}
	}

	print();
}

void print() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (board[i][j] == 0)
				cout << '.';
			else if (board[i][j] == -1)
				cout << 'I';
			else if (board[i][j] == 1)
				cout << 'R';
		}
		cout << "\n";
	}
}