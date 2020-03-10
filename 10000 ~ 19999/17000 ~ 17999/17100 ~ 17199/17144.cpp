#include <iostream>

using namespace std;

int N, M;
int S;
int cleaner = 0;

int room[51][51];
int dir[4][2] = { {0,1}, {0,-1}, {1,0}, {-1,0} };

void spread();
void clean();
int sum();

int main() {
	cin >> N >> M >> S;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> room[i][j];

			if (cleaner == 0 && room[i][j] == -1) {
				cleaner = i;
			}
		}
	}

	for (int i = 0; i < S; i++) {
		spread();
		clean();
	}

	cout << sum();
}

void spread() {
	int temp[51][51] = { 0, };
	bool check;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			check = false;
			if (room[i][j] >= 5) {
				int nextX, nextY, count = 0;
				check = true;

				for (int k = 0; k < 4; k++) {
					nextX = j + dir[k][0];
					nextY = i + dir[k][1];

					if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
						if (room[nextY][nextX] != -1) {
							count++;
							temp[nextY][nextX] += room[i][j] / 5;
						}
					}
				}

				temp[i][j] += room[i][j] - (room[i][j] / 5) * count;
			}
			else
				temp[i][j] += room[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			room[i][j] = temp[i][j];
		}
	}
}

void clean() {
	int first = cleaner;
	int second = cleaner + 1;

	// 위쪽
	for (int i = first - 1; i > 0; i--) { // down
		room[i][0] = room[i - 1][0];
	}

	for (int i = 0; i < M - 1; i++) { // left
		room[0][i] = room[0][i + 1];
	}

	for (int i = 0; i < first; i++) { // up
		room[i][M - 1] = room[i + 1][M - 1];
	}
	
	for (int i = M - 1; i > 1; i--) { // right
		room[first][i] = room[first][i - 1];
	}

	room[first][1] = 0;


	// 아래쪽

	for (int i = second + 1; i < N - 1; i++) { // up
		room[i][0] = room[i + 1][0];
	}

	for (int i = 0; i < M - 1; i++) { // left
		room[N - 1][i] = room[N - 1][i + 1];
	}

	for (int i = N - 1; i > second; i--) { // down
		room[i][M - 1] = room[i - 1][M - 1];
	}

	for (int i = M - 1; i > 0; i--) { // right
		room[second][i] = room[second][i - 1];
	}
	room[second][1] = 0;
}

int sum() {
	int res = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if(room[i][j] != -1)
				res += room[i][j];
		}
	}

	return res;
}