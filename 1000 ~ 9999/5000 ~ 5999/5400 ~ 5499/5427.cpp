#include <iostream>
#include <queue>

using namespace std;

int dir[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1} };
char building[1001][1001];
int W, H;

struct location {
	int x, y;
	int time;
};

queue<location> human;
queue<location> fire;

void solve();
void input();
int move();

int main() {
	solve();

	return 0;
}

void solve() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		input();

		int res = move();

		while (!human.empty())
			human.pop();

		while (!fire.empty())
			fire.pop();

		if (res == -1)
			cout << "IMPOSSIBLE\n";
		else
			cout << res + 1 << "\n";
	}
}

void input() {
	cin >> W >> H;

	location temp;

	for (int i = 0; i < H; i++) {
		cin >> building[i];

		for (int j = 0; j < W; j++) {
			temp.x = j;
			temp.y = i;
			temp.time = 0;

			if (building[i][j] == '*') {
				fire.push(temp);
			}
			else if (building[i][j] == '@') {
				human.push(temp);
			}
		}
	}
}

int move() {
	while (true) {
		int size = fire.size();
		location cur, next;

		for (int i = 0; i < size; i++) {
			cur = fire.front();
			fire.pop();

			for (int j = 0; j < 4; j++) {
				next.x = cur.x + dir[j][0];
				next.y = cur.y + dir[j][1];

				if (0 <= next.x&&next.x < W && 0 <= next.y && next.y < H) {
					if (building[next.y][next.x] == '.' || building[next.y][next.x] == '@') {
						building[next.y][next.x] = '*';
						fire.push(next);
					}
				}
			}
		}

		size = human.size();

		for (int i = 0; i < size; i++) {
			cur = human.front();
			human.pop();

			if (cur.x == 0 || cur.y == 0 || cur.x == W - 1 || cur.y == H - 1)
				return cur.time;

			for (int j = 0; j < 4; j++) {
				next.x = cur.x + dir[j][0];
				next.y = cur.y + dir[j][1];
				next.time = cur.time + 1;

				if (0 <= next.x&&next.x < W && 0 <= next.y && next.y < H) {
					if (building[next.y][next.x] == '.') {
						building[next.y][next.x] = '*';
						human.push(next);
					}
				}
			}
		}

		if (human.size() == 0)
			return -1;
	}
}