#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dir[4][2] = { {-1,0},{1,0},{0,-1},{0,1} };

bool visit[26][26];
int board[26][26];

vector<int> house;

int N;

void dfs(int x, int y, int index);

int main() {
	cin >> N;

	char *input = new char[N + 1];

	for (int i = 1; i <= N; i++) {
		cin >> input;
		for (int j = 1; j <= N; j++) {
			board[i][j] = input[j - 1] - '0';
			visit[i][j] = false;
		}
	}

	int index = 0;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
 			if (board[i][j] == 1 && !visit[i][j]) {
				house.push_back(0);
				dfs(j, i, index);
				index++;
			}
		}
	}

	cout << house.size() << endl;

	sort(house.begin(), house.end());

	for (int i = 0; i < house.size(); i++) {
		cout << house[i] << endl;
	}
}

void dfs(int x, int y, int index) {
	visit[y][x] = true;
	house[index]++;

	for (int i = 0; i < 4; i++) {
		int nextX = x + dir[i][0];
		int nextY = y + dir[i][1];

		if (1 <= nextX && nextX <= N && 1 <= nextY && nextY <= N) {
			if (!visit[nextY][nextX] && board[nextY][nextX] == 1) {
				dfs(nextX, nextY, index);
			}
		}
	}
}