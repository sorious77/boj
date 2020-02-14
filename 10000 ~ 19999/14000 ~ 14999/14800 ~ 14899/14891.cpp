#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <cmath>

using namespace std;

vector<int> wheel[4];
bool visit[4];
int K;

void rotate(int num, int dir);
void clock(int num, int dir);

int main() {
	for (int i = 0; i < 4; i++) {
		string input;
		cin >> input;
		for (int j = 0; j < 8; j++) {
			wheel[i].push_back(input[j] - '0');
		}
	}

	cin >> K;

	int num, dir;
	for (int i = 0; i < K; i++) {
		cin >> num >> dir;

		memset(visit, false, sizeof(visit));
		rotate(num - 1, dir);
	}

	int sum = 0;
	for (int i = 0; i < 4; i++) {
		sum += wheel[i][0] * pow(2, i);
	}

	cout << sum;
}

void rotate(int num, int dir) {
	int clockwise = dir < 0 ? 1 : -1; // 해당 톱니바퀴가 시계방향으로 돌 경우, 옆의 톱니바퀴는 다른 방향으로 돌아야함
	visit[num] = true;

	if (num > 0) { // 왼쪽에 톱니바퀴가 있을 경우
		if (wheel[num - 1][2] != wheel[num][6] && !visit[num - 1]) { // 왼쪽 톱니바퀴를 돌릴 수 있는 경우
			rotate(num - 1, clockwise); // 왼쪽 톱니바퀴를 해당 톱니바퀴의 반대 방향으로 돌림
		}
	}

	if (num < 3) { // 오른쪽에 톱니바퀴가 있을 경우
		if (wheel[num][2] != wheel[num + 1][6] && !visit[num + 1]) { // 오른쪽 톱니바퀴를 돌릴 수 잇는 경우
			rotate(num + 1, clockwise); // 오른쪽 톱니바퀴를 해당 톱니바퀴의 반대 방향으로 돌림
		}
	}
		
	clock(num, dir);
}

void clock(int num, int dir) {
	vector<int> tempWheel(wheel[num]);
	int temp;
	if (dir == -1) {
		temp = tempWheel[0];
		for (int i = 0; i < 7; i++) {
			tempWheel[i] = tempWheel[i + 1];
		}
		tempWheel[7] = temp;
	}

	if (dir == 1) {
		temp = tempWheel[7];
		for (int i = 7; i > 0; i--) {
			tempWheel[i] = tempWheel[i - 1];
		}
		tempWheel[0] = temp;
	}

	wheel[num] = tempWheel;
}