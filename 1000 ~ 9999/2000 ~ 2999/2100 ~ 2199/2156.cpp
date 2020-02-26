#include <iostream>
#include <algorithm>

using namespace std;

int N;
int wine[10001] = { 0, };
int score[10001] = { 0, };

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> wine[i];
	}

	score[1] = wine[1];
	score[2] = wine[1] + wine[2];

	for (int i = 3; i <= N; i++) {
		score[i] = max(wine[i] + wine[i - 1] + score[i - 3], wine[i] + score[i - 2]);
		score[i] = max(score[i], score[i - 1]);
	}

	cout << max(score[N], score[N - 1]) << endl;

	return 0;
}