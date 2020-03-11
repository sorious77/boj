#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

void input();
void solve();
void dfs(int startX, int startY, int curX, int curY, int prevDir);
int nextDir(int curDir);

char ch[51][51];
int visit[51][51] = { 0, };
int N, M;
int dir[4][2] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
bool finish = false;

int main() {
	input();
	solve();

	if (finish) {
		cout << "Yes" << "\n";
	}
	else {
		cout << "No" << "\n";
	}

	return 0;
}

void input() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> ch[i];
	}
}

void solve() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			dfs(j, i, j, i, -1);

			memset(visit, false, sizeof(visit));

			if (finish)
				return;
		}
	}
}

void dfs(int startX, int startY, int curX, int curY, int prevDir) {
	if (startX == curX && startY == curY && visit[startY][startX]) {
		finish = true;
		return;
	}

	if (finish)
		return;

	for (int i = 0; i < 4; i++) {
		if (i == prevDir)
			continue;

		int nextX = curX + dir[i][0];
		int nextY = curY + dir[i][1];

		if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
			if (!visit[nextY][nextX] && ch[startY][startX] == ch[nextY][nextX]) {
				visit[nextY][nextX] = true;
				dfs(startX, startY, nextX, nextY, nextDir(i));
			}
		}
	}
}

int nextDir(int curDir) {
	switch (curDir) {
	case 0:
		return 1;
	case 1:
		return 0;
	case 2:
		return 3;
	case 3:
		return 2;
	}
}