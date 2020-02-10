#include <iostream>
#include <queue>

using namespace std;

int Dir[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };

int n, m;
int board[8][8];

void copy_array(int board[8][8], int temp[8][8]);
int findIndex(int first_index);
int bfs(int temp[8][8]);

int main() {
	cin >> n >> m; // 연구소의 크기

	int temp[8][8] = { 0, };

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> board[i][j];
	}

	int curX = 0, curY = 0;

	int max = -1;

	for (int i = 0; i < n * m; i++) {
		curX = i / m;
		curY = i % m;

		if (board[curX][curY] == 0){
			int res = findIndex(i);
			if (res > max)
				max = res;
		}
	}
	cout << max;
	return 0;
}

void copy_array(int board[8][8], int temp[8][8]) {
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++)
			temp[i][j] = board[i][j];
	}
}

int findIndex(int first_index) {
	int x, y;
	int max = -1;

	int temp[8][8];

	for (int i = first_index + 1; i < n*m; i++) {
		x = i / m;
		y = i % m;

		if (board[x][y] == 0) {
			for (int j = i + 1; j < n*m; j++) {
				x = j / m;
				y = j % m;

				if (board[x][y] == 0) {
					copy_array(board, temp);
					temp[first_index / m][first_index % m] = 1;
					temp[i / m][i % m] = 1;
					temp[j / m][j % m] = 1;

					//printf("first : %d, second : %d, third : %d\n", first_index, i, j);
					int res = bfs(temp);

					if (max < res)
						max = res;
				}
			}
		}
	}

	return max;
}

int bfs(int temp[8][8]) {
	// 더이상 못 넓어질때까지 넓힘
	queue<pair<int, int>> q;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (temp[i][j] == 2)
				q.push(make_pair(i, j));
		}
	}

	while (!q.empty()) {
		int x, y;
		x = q.front().first;
		y = q.front().second;

		for (int i = 0; i < 4; i++) {
			int xTemp = x + Dir[i][0];
			int yTemp = y + Dir[i][1];

			if (xTemp >= 0 && xTemp < n && yTemp >= 0 && yTemp < m) {
				if (temp[xTemp][yTemp] == 0) {
					q.push(make_pair(xTemp, yTemp));
					temp[xTemp][yTemp] = 2;
				}
			}
		}
		q.pop();
	}

	// 남은 0인 부분을 return
	int count = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			//printf("%d ", temp[i][j]);
			if (temp[i][j] == 0)
				count++;
		}
		//cout << endl;
	}

	return count;
}