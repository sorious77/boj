#include <iostream>
#include <queue>

using namespace std;

class pos {
public:
	int x, y;

	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

int N;
int** board;
int dir[3][2] = { {1,0},{1,1},{0,1} };

bool canMove(pos p, int next_dir);

int main() {
	cin >> N;

	board = new int* [N];

	for (int i = 0; i < N; i++) {
		board[i] = new int[N];

		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}

	queue<pair<pair<pos, pos>, int>> q;

	int count = 0;
	q.push(make_pair(make_pair(pos(0, 0), pos(1, 0)), 0));

	while (!q.empty()) {
		pos p1 = q.front().first.first; // 파이프의 뒤쪽 부분
		pos p2 = q.front().first.second; // 파이프의 앞쪽 부분
		int cur_dir = q.front().second; // 현재 파이프의 진행 방향
		q.pop();

		if ((p2.x == N - 1) && p2.y == N - 1) {
			count++;
			continue;
		}

		if (cur_dir == 0) { // 가로로 진행했을 경우
			for (int i = 0; i <= 1; i++) { // 가로 or 대각선 이동 가능
				if (canMove(p2, i)) {
					q.push(make_pair(make_pair(p2, pos(p2.x + dir[i][0], p2.y + dir[i][1])), i));
				}
			}
		}
		else if (cur_dir == 1) { // 대각선으로 진행했을 경우
			for (int i = 0; i <= 2; i++) { // 가로 or 대각선 or 세로 이동 가능
				if (canMove(p2, i)) {
					q.push(make_pair(make_pair(p2, pos(p2.x + dir[i][0], p2.y + dir[i][1])), i));
				}
			}
		}
		else {
			for (int i = 1; i <= 2; i++) { // 대각선 or 세로 이동 가능
				if (canMove(p2, i)) {
					q.push(make_pair(make_pair(p2, pos(p2.x + dir[i][0], p2.y + dir[i][1])), i));
				}
			}
		}
	}

	cout << count;

	return 0;
}

bool canMove(pos p, int next_dir) {

	if (next_dir == 0) {
		if (p.x + 1 < N) {
			if (board[p.y][p.x + 1] != 1)
				return true;
		}
		return false;
	}
	else if (next_dir == 1) {
		if (p.x + 1 < N && p.y + 1 < N) {
			if ((board[p.y + 1][p.x + 1] != 1) && (board[p.y + 1][p.x] != 1) && (board[p.y][p.x + 1] != 1))
				return true;
		}
		return false;
	}
	else {
		if (p.y + 1 < N) {
			if (board[p.y + 1][p.x] != 1)
				return true;
		}
		return false;
	}
}