#include <iostream>

using namespace std;

int N, M;
int arr[301][301];
int sum[301][301] = { 0, };

void calc();
void solve();

int main() {
	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> arr[i][j];
		}
	}

	calc();

	solve();

	return 0;
}

void calc() {
	sum[1][1] = arr[1][1];

	for (int i = 2; i <= N; i++) {
		sum[i][1] = sum[i - 1][1] + arr[i][1];
	}

	for (int i = 2; i <= M; i++) {
		sum[1][i] = sum[1][i-1] + arr[1][i];
	}

	for (int i = 2; i <= N; i++) {
		for (int j = 2; j <= M; j++) {
			sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
		}
	}

}

void solve() {
	int K;

	cin >> K;

	for (int i = 0; i < K; i++) {
		int x1, x2, y1, y2;
		cin >> y1 >> x1 >> y2 >> x2;

		cout << sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1] << "\n";
	}
}