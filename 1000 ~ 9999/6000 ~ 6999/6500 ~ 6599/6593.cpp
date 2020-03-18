#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

bool visit[31][31][31] = { false, };
char building[31][31][31];
int dir[6][3] = { {1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1} };

typedef struct _location {
	int x, y, z;
	int m;
}location;

void solve();
void input(int L, int R, int C);

queue<location> q;

int main() {
	solve();

	return 0;
}

void solve() {
	int L, R, C;

	while (true) {
		cin >> L >> R >> C;

		if (L == 0 && R == 0 && C == 0)
			break;

		memset(visit, false, sizeof(visit));

		input(L, R, C);

		bool escape = false;

		while (!q.empty()) {
			location cur = q.front();
			q.pop();

			if (building[cur.z][cur.y][cur.x] == 'E') {
				printf("Escaped in %d minute(s).\n", cur.m);
				escape = true;
				break;
			}

			for (int i = 0; i < 6; i++) {
				location next = cur;
				next.x += dir[i][0];
				next.y += dir[i][1];
				next.z += dir[i][2];
				next.m += 1;

				if (0 <= next.x && next.x < C && 0 <= next.y && next.y < R && 0 <= next.z && next.z < L) {
					if (building[next.z][next.y][next.x] != '#' && !visit[next.z][next.y][next.x]) {
						q.push(next);
						visit[next.z][next.y][next.x] = true;
					}
				}
			}
		}

		while (!q.empty()) {
			q.pop();
		}

		if (!escape)
			cout << "Trapped!\n";
	}
}

void input(int L, int R, int C) {
	location temp;

	for (int i = 0; i < L; i++) {
		for (int j = 0; j < R; j++) {
			cin >> building[i][j];

			for (int k = 0; k < C; k++) {
				if (building[i][j][k] == 'S') {
					temp.x = k;
					temp.y = j;
					temp.z = i;
					temp.m = 0;

					visit[i][j][k] = true;

					q.push(temp);
				}
			}
		}
	}
}