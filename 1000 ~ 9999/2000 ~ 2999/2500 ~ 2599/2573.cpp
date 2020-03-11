#include <iostream>
#include <queue>

using namespace std;

int N, M;
int dir[4][2] = { {0,1}, {1,0}, {-1,0,}, {0,-1} };
int ice[301][301] = { 0, };

void input();
int count();
void melt();

int main() {
	int res, year = 0;

	input();

	while (true) {
		res = count();
		if (res == 0) {
			cout << "0" << "\n";
			break;
		}
		if (res >= 2) {
			cout << year << "\n";
			break;
		}
		melt();
		year++;
	}

	return 0;
}

void input() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> ice[i][j];
		}
	}
}

int count() {
	bool visit[301][301] = { false, };

	queue<pair<int, int>> q;

	int cnt = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (ice[i][j] != 0 && !visit[i][j]) {
				q.push(make_pair(j, i));
				visit[i][j] = true;
				cnt++;

				while (!q.empty()) {
					int curX = q.front().first;
					int curY = q.front().second;
					q.pop();

					for (int k = 0; k < 4; k++) {
						int nextX = curX + dir[k][0];
						int nextY = curY + dir[k][1];

						if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
							if (ice[nextY][nextX] != 0 && !visit[nextY][nextX]) {
								q.push(make_pair(nextX, nextY));
								visit[nextY][nextX] = true;
							}
						}
					}
				}
			}
		}
	}

	return cnt;
}

void melt() {
	int cnt = 0;
	int temp[301][301] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (ice[i][j] != 0) {
				cnt = 0;

				for (int k = 0; k < 4; k++) {
					int nextX = j + dir[k][0];
					int nextY = i + dir[k][1];

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
						if (ice[nextY][nextX] == 0)
							cnt++;
					}
				}

				if (ice[i][j] - cnt < 0)
					temp[i][j] = 0;
				else
					temp[i][j] = ice[i][j] - cnt;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			ice[i][j] = temp[i][j];
		}
	}
}