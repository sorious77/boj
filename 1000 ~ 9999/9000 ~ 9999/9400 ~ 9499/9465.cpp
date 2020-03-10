#include <iostream>
#include <algorithm>

using namespace std;

int dir[4][2] = { {1,0}, {-1,0}, {0,1},{0,-1} };

int input[2][100001];
int score[2][100001];

int N;

int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	int test_case;
	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		cin >> N;

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> input[i][j];
			}

			score[i][0] = 0;
			score[i][1] = input[i][1];
		}

		for (int i = 2; i <= N; i++) {
			score[0][i] = max(score[1][i - 2], score[1][i - 1]) + input[0][i];
			score[1][i] = max(score[0][i - 2], score[0][i - 1]) + input[1][i];
		}

		cout << max(score[0][N], score[1][N]) << "\n";
	}

	return 0;
}