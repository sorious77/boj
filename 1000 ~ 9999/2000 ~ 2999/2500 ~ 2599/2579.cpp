#include <iostream>
#include <algorithm>

using namespace std;

int N;
int stair[301] = { 0, };
int score[301] = { 0, };

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> stair[i];
	}

	score[1] = stair[1];
	score[2] = stair[1] + stair[2];

	for (int i = 3; i <= N; i++) {
		score[i] = max(stair[i] + stair[i - 1] + score[i - 3], stair[i] + score[i - 2]);
	}

	cout << score[N] << endl;

	return 0;
}