#include <iostream>

using namespace std;

void solve();
void input(int *n, int arr[][101]);

int main() {
	solve();

	return 0;
}

void solve() {
	int n, arr[101][101];
	long long count[101][101] = { 0, };

	input(&n, arr);

	count[1][1] = 1;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == n && j == n)
				break;

			// 오른쪽으로 이동
			if (j + arr[i][j] <= n) {
				count[i][j + arr[i][j]] += count[i][j];
			}

			// 아래로 이동
			if (i + arr[i][j] <= n) {
				count[i + arr[i][j]][j] += count[i][j];
			}
		}
	}

	cout << count[n][n];
}

void input(int *n, int arr[][101]) {
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	cin >> *n;

	for (int i = 1; i <= *n; i++) {
		for (int j = 1; j <= *n; j++) {
			cin >> arr[i][j];
		}
	}
}