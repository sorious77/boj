#include <iostream>
#include <queue>

using namespace std;

int dir[4][2] = { {-1,0}, {1,0}, {0,-1}, {0,1} };

int board[1001][1001] = { 0, };
int visit[1001][1001][2] = { 0, }; // [x][y][z]가 0이 아닐 경우 -> z가 0이면 벽을 부수지 않고 도착함, z가 1이면 벽을 부수고 도착함
int N, M;

queue<pair<pair<int, int>, int>> q;

void bfs();

int main() {
	cin >> N >> M;

	char *input = new char[M + 1];
	for (int i = 1; i <= N; i++) {
		scanf("%s", input);

		for (int j = 1; j <= M; j++) {
			board[i][j] = input[j - 1] - '0';
		}
	}

	bfs();
}

void bfs() {
	q.push(make_pair(make_pair(1, 1), 0));
	visit[1][1][0] = 1;

	int ans = -1;

	while (!q.empty()) {
		int curX = q.front().first.first;
		int curY = q.front().first.second;
		int smash = q.front().second;
		
		q.pop();

		if (curX == M && curY == N) {
			ans = visit[curY][curX][smash];
			break;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dir[i][0];
			int nextY = curY + dir[i][1];

			if (1 <= nextX && nextX <= M && 1 <= nextY && nextY <= N) {
				if (board[nextY][nextX] == 1 && smash == 0) { // 벽인데 아직 깬 적이 없는 경우
					visit[nextY][nextX][1] = visit[curY][curX][0] + 1;
					q.push(make_pair(make_pair(nextX, nextY), 1));
				}
				else if (board[nextY][nextX] == 0 && visit[nextY][nextX][smash] == 0) {
					visit[nextY][nextX][smash] = visit[curY][curX][smash] + 1;
					q.push(make_pair(make_pair(nextX, nextY), smash));
				}
			}
		}
	}
	cout << ans;
}