#include <iostream>

using namespace std;

int N;
int arr[2188][2188];
int paper[3] = { 0, };

void check(int startX, int startY, int endX, int endY);

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> arr[i][j];
		}
	}

	check(1, 1, N, N);

	for (int i = 0; i < 3; i++)
		cout << paper[i] << "\n";

	return 0;
}

void check(int startX, int startY, int endX, int endY) {
	int start = arr[startY][startX];
	int size = (endX - startX + 1) / 3;

	for (int i = startY; i <= endY; i++) {
		for (int j = startX; j <= endX; j++) {
			if (start != arr[i][j]) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						check(startX + size * l, startY + size * k, startX + size * (l + 1) - 1, startY + size * (k + 1) - 1);
					}
				}
				return;
			}
		}
	}

	paper[start + 1]++;
}