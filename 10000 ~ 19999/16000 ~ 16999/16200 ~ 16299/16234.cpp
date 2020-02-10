#include <iostream>
#include <queue>
#include <cmath>
#include <vector>

using namespace std;

int N, L, R;
int arr[50][50];
bool visit[50][50];

int dir[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1} };

void initVisit(); // visit 배열을 false로 초기화
bool checkVisit(); // true -> 인구 이동 있음, false -> 없음
bool canMove();
void move();
void bfs(int x, int y);
void print();

int main() {
	cin >> N >> L >> R;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	int count = 0;
	while (true) {
		initVisit();

		move();
		if (!checkVisit()) {
			break;
		}

		count++;
	}

	cout << count;
}

void initVisit() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visit[i][j] = false;
		}
	}
}

bool checkVisit() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j])
				return true;
		}
	}

	return false;
}

bool canMove(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int nextX = x + dir[i][0];
		int nextY = y + dir[i][1];

		if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
			int diff = abs(arr[x][y] - arr[nextX][nextY]);
			if (L <= diff && diff <= R)
				return true;
		}
	}
	return false;
}

void move() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visit[i][j] && canMove(i,j)) {
				bfs(i, j);
			}
		}
	}
}

void bfs(int x, int y) {
	vector <pair<int, int>> q;
	q.push_back(make_pair(x, y));

	int index = 0;
	int curX, curY;
	int sum = arr[x][y];
	int nextX, nextY;

	visit[x][y] = true;

	while (true) {
		if (index >= q.size())
			break;

		curX = q[index].first;
		curY = q[index].second;

		for (int i = 0; i < 4; i++) {
			nextX = curX + dir[i][0];
			nextY = curY + dir[i][1];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				int diff = abs(arr[curX][curY] - arr[nextX][nextY]);
				if (!visit[nextX][nextY] && L <= diff && diff <= R) {
					q.push_back(make_pair(nextX, nextY));
					sum += arr[nextX][nextY];
					visit[nextX][nextY] = true;
				}
			}
		}
		index++;
	}

	for (int i = 0; i < q.size(); i++) {
		arr[q[i].first][q[i].second] = sum / q.size();
	}
}

void print() {
	printf("\n\n\n");
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}