#include <iostream>

using namespace std;

int countDiff(int x, int y);

char board[51][51];

int main() {
	int N, M;
	cin >> N >> M;


	for (int i = 0; i < N; i++) {
		scanf("%s", board[i]);
	}

	int min = 100;

	for (int i = 0; i <= N - 8; i++) {
		for (int j = 0; j <= M - 8; j++) {
			int res = countDiff(j, i);
			if (res < min)
				min = res;
		}
	}

	cout << min;
}

int countDiff(int x, int y) {
	int count = 0;
	if ((x + y) % 2 == 0) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					if (board[y][x] != board[i + y][j + x])
						count++;
				}
				else {
					if (board[y][x] == board[i + y][j + x])
						count++;
				}
			}
		}
	}
	else {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					if (board[y][x] == board[i + y][j + x])
						count++;
				}
				else {
					if (board[y][x] != board[i + y][j + x])
						count++;
				}
			}
		}
	}

	if (count > 32)
		return 64 - count;
	else
		return count;
}