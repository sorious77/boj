#include <iostream>
#include <cmath>
#include <cstring>

using namespace std;

int N, L;

int map[100][100];
int result = 0;
bool visit[100][100];

void findRoad();

int main() {
	cin >> N >> L;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	findRoad();

	cout << result;
}

void findRoad() {
	int prev;
	int count = 0;
	bool check = true;

	for (int i = 0; i < N; i++) { // 가로 길
		prev = map[i][0]; // 해당 길의 제일 왼쪽 좌표
		count = 0;
		check = true;

		memset(visit, false, sizeof(visit));

		for (int j = 0; j < N; j++) {
			if (!check)
				break;

			if (prev == map[i][j]) // 같은 높이인 경우
				count++; // 길이를 구함
			else {
				if (abs(prev - map[i][j]) >= 2) { // 높이 차이가 2 이상
					check = false;
					break;
				}

				if (prev > map[i][j]) { // 높이가 낮아진 경우
					int start = j;
					int temp = map[i][j];
					count = 1;

					while (j + 1 < N) { // 낮은 높이의 길이를 구함
						if ((map[i][j + 1] != temp) || count >= L)
							break;

						j++;
						count++;
					}
					if (count < L) { // 길이가 L보다 작으면 경사로를 놓을 수 없음
						check = false;
						break;
					}

					// 이미 경사로가 놓인 경우
					for (int k = start; k <= j; k++) {
						if (visit[i][k]) {
							check = false;
						}
					}

					// 경사로를 놓음
					for (int k = start; k <= j; k++) {
						visit[i][k] = true;
					}
					count = 0;
				}
				else { // 높이가 높아진 경우
					if (count < L) { // 길이가 L보다 작으면 경사로를 놓을 수 없음
						check = false;
						break;
					}

					// 이미 경사로가 놓인 경우
					for (int k = 0; k < L; k++) {
						if (visit[i][j - k - 1]) {
							check = false;
						}
					}

					// 경사로를 놓음
					for (int k = 0; k < L; k++) {
						visit[i][j - k - 1] = true;
					}
					count = 1; // 더 높은 부분으로, 경사로가 놓여지지 않았기 때문에 길이가 1이 됨
				}
				prev = map[i][j];
			}
		}

		if (check) {
			result++;
		}
	}
	

	for (int i = 0; i < N; i++) { // 세로 길
		prev = map[0][i]; // 해당 길의 제일 위쪽 좌표
		count = 0;
		check = true;

		memset(visit, false, sizeof(visit));

		for (int j = 0; j < N; j++) {
			if (!check)
				break;

			if (prev == map[j][i]) // 같은 높이인 경우
				count++; // 길이를 구함
			else {
				if (abs(prev - map[j][i]) >= 2) { // 높이 차이가 2 이상
					check = false;
					break;
				}

				if (prev > map[j][i]) { // 높이가 낮아진 경우
					int start = j;
					int temp = map[j][i];
					count = 1;

					while (j + 1 < N) { // 낮은 높이의 길이를 구함
						if ((map[j + 1][i] != temp) || count >= L)
							break;

						j++;
						count++;
					}
					if (count < L) { // 길이가 L보다 작으면 경사로를 놓을 수 없음
						check = false;
						break;
					}

					// 이미 경사로가 놓인 경우
					for (int k = start; k <= j; k++) {
						if (visit[k][i]) {
							check = false;
						}
					}

					// 경사로를 놓음
					for (int k = start; k <= j; k++) {
						visit[k][i] = true;
					}
					count = 0;
				}
				else { // 높이가 높아진 경우
					if (count < L) { // 길이가 L보다 작으면 경사로를 놓을 수 없음
						check = false;
						break;
					}

					// 이미 경사로가 놓인 경우
					for (int k = 0; k < L; k++) {
						if (visit[j - k - 1][i]) {
							check = false;
						}
					}

					// 경사로를 놓음
					for (int k = 0; k < L; k++) {
						visit[j - k - 1][i] = true;
					}
					count = 1;
				}
				prev = map[j][i];
			}
		}

		if (check) {
			result++;
		}
	}
}