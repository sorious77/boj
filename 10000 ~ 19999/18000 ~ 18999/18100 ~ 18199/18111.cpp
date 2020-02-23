#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int land[501][501] = { 0, };
int N, M, B;

int main() {
	cin >> N >> M >> B;

	int min = INT_MAX;
	int max = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> land[i][j];

			if (land[i][j] < min)
				min = land[i][j];

			if (land[i][j] > max)
				max = land[i][j];
		}
	}

	int time = INT_MAX;
	int height = 0;

	bool can_build = false;

	for (int i = max; i >= min; i--) {
		int sum_build = 0;
		int sum_remove = 0;

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				int temp = i - land[j][k];

				if (temp < 0)
					sum_remove += temp * -1;
				else
					sum_build += temp;
			}
		}

		if (sum_build <= sum_remove + B) { // 제거한 블록과 기존 블록을 사용해 쌓을 수 있는 경우
			int temp = sum_build + sum_remove * 2; // 쌓는 시간 + 제거 시간
			if (time > temp) {
				time = temp;
				height = i;
			}
			
			if (temp == time)
				if (height < i)
					height = i;
		}
	}

	printf("%d %d\n", time, height);
}