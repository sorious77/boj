#include <iostream>

using namespace std;

int N;
int arr[129][129];
int white = 0;
int blue = 0;

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

	cout << white << "\n" << blue;

	return 0;
}

void check(int startX, int startY, int endX, int endY) {
	int start = arr[startY][startX];
	int size = (endX - startX + 1) / 2;

	for (int i = startY; i <= endY; i++) {
		for (int j = startX; j <= endX; j++) {
			if (start != arr[i][j]) {
				check(startX, startY, endX - size, endY - size);
				check(startX + size, startY, endX, endY - size);
				check(startX, startY + size, endX - size, endY);
				check(startX + size, startY + size, endX, endY);
				
				return;
			}
		}
	}

	if (start == 0)
		white++;
	else
		blue++;
}