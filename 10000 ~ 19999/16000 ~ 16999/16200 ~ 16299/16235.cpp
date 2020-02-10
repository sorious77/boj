#include <iostream>
#include <vector>
#include <algorithm>

#define MAX_SIZE 10

using namespace std;

int N, M, K; // N : 땅의 크기, M : 구입한 나무의 수, K : K년이 지났을 때

int initSoil[MAX_SIZE + 1][MAX_SIZE + 1];
int soil[MAX_SIZE + 1][MAX_SIZE + 1]; // index가 1,1부터 시작, 해당 좌표의 양분
vector<int> tree[MAX_SIZE + 1][MAX_SIZE + 1]; // 해당 좌표에 심겨져 있는 나무들의 나이

int dir[8][2] = { {-1, -1}, {-1,0}, {-1,1}, {0, -1}, {0,1}, {1,-1}, {1,0}, {1,1} }; // 8가지 방향

void grow();
void ss();
void fall();
void winter();

int main() {
	cin >> N >> M >> K;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> initSoil[i][j]; // 초기 양분 값
			soil[i][j] = 5;
		}
	}

	for (int i = 0; i < M; i++) {
		int x, y, age;

		cin >> x >> y >> age;

		tree[x][y].push_back(age);
	}

	grow();
}

void grow() {
	for (int i = 0; i < K; i++) {
		// 봄, 여름
		ss();

		// 가을
		fall();

		// 겨울
		winter();
	}

	int count = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			count += tree[i][j].size();
		}
	}

	cout << count;
}

void ss() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			vector<int> temp;
			int sum = 0, index = -1;
			sort(tree[i][j].begin(), tree[i][j].end());

			int food = soil[i][j]; // 해당 칸의 양분

			for (int k = 0; k < tree[i][j].size(); k++) {
				int age = tree[i][j][k];
				if (food < age) { // 양분을 더 먹을 수 없다면
					sum += age / 2;
					index = k;
				}
				else {
					food -= age; // 나이만큼 양분을 먹음
					temp.push_back(age + 1);
				}
			}

			soil[i][j] = food + sum;
			tree[i][j] = temp;
		}
	}
}

void fall() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			vector<int> temp(tree[i][j]);

			for (int k = 0; k < temp.size(); k++) {
				if (temp[k] % 5 == 0) { // 나이가 5의 배수라면
					for (int d = 0; d < 8; d++) { // 인접한 8칸에 나이가 1인 나무 추가
						int nextX = i + dir[d][0];
						int nextY = j + dir[d][1];

						if (1 <= nextX && nextX <= N && 1 <= nextY && nextY <= N) {
							tree[nextX][nextY].push_back(1);
						}
					}
				}
			}
		}
	}
}

void winter() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			soil[i][j] += initSoil[i][j];
		}
	}
}