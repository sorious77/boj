#include <iostream>
#include <cstring>

using namespace std;

int N;
int board[21][21];
int res = -1;

void dfs(int b[21][21], int count);

int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
			if (res < board[i][j])
				res = board[i][j];
		}
	}

	dfs(board, 1);

	cout << res;

	return 0;
}

void dfs(int b[21][21], int count) {
	if (count > 5)
		return;

	int temp[21][21] = { 0, };

	// up

	memset(temp, 0, sizeof(temp));
	int index = 0;
	int data;
	for (int i = 0; i < N; i++) {
		index = 0;
		data = 0;
		for (int j = 0; j < N; j++) {
			if (b[j][i] == 0)
				continue;
			
			if (data != 0) {
				if (data == b[j][i]) {
					if (data * 2 > res)
						res = data * 2;
					temp[index][i] = data * 2;
					data = 0;
				}
				else {
					temp[index][i] = data;
					data = b[j][i];
				}
				index++;
			}
			else {
				data = b[j][i];
			}
		}

		if (data != 0)
			temp[index][i] = data;
	}
	dfs(temp, count + 1);

	// down
	memset(temp, 0, sizeof(temp));
	index = 0;
	for (int i = 0; i < N; i++) {
		index = N - 1;
		data = 0;
		for (int j = N - 1; j >= 0; j--) {
			if (b[j][i] == 0)
				continue;

			if (data != 0) {
				if (data == b[j][i]) {
					if (data * 2 > res)
						res = data * 2;
					temp[index][i] = data * 2;
					data = 0;
				}
				else {
					temp[index][i] = data;
					data = b[j][i];
				}
				index--;
			}
			else {
				data = b[j][i];
			}
		}

		if (data != 0)
			temp[index][i] = data;
	}
	dfs(temp, count + 1);

	// left
	memset(temp, 0, sizeof(temp));
	index = 0;
	for (int i = 0; i < N; i++) {
		index = 0;
		data = 0;
		for (int j = 0; j < N; j++) {
			if (b[i][j] == 0)
				continue;

			if (data != 0) {
				if (data == b[i][j]) {
					if (data * 2 > res)
						res = data * 2;
					temp[i][index] = data * 2;
					data = 0;
				}
				else {
					temp[i][index] = data;
					data = b[i][j];
				}
				index++;
			}
			else {
				data = b[i][j];
			}
		}

		if (data != 0)
			temp[i][index] = data;
	}
	dfs(temp, count + 1);


	// right
	memset(temp, 0, sizeof(temp));
	index = 0;
	for (int i = 0; i < N; i++) {
		index = N - 1;
		data = 0;
		for (int j = N - 1; j >= 0; j--) {
			if (b[i][j] == 0)
				continue;

			if (data != 0) {
				if (data == b[i][j]) {
					if (data * 2 > res)
						res = data * 2;
					temp[i][index] = data * 2;
					data = 0;
				}
				else {
					temp[i][index] = data;
					data = b[i][j];
				}
				index--;
			}
			else {
				data = b[i][j];
			}
		}

		if (data != 0)
			temp[i][index] = data;
	}
	dfs(temp, count + 1);
}