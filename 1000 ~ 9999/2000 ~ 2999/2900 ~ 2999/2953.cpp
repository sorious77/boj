#include <stdio.h>

int main() {
	int arr[5][5] = { 0, };
	int sum[5] = { 0, }, max;
	int i, j;

	for (i = 0; i < 5; i++) {
		for (j = 0; j < 5; j++) {
			if (i == j)
				continue;
			scanf("%d", &arr[i][j]);
		}
	}

	for (i = 0; i < 5; i++) {
		for (j = 0; j < 5; j++) {
			sum[i] += arr[i][j];
		}
	}
	max = -1;
	for (i = 0; i < 5; i++) {
		if (max < sum[i]) {
			j = i;
			max = sum[i];
		}
	}

	printf("%d %d\n", j + 1, max);
}