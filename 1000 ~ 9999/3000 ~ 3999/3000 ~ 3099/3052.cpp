#include <stdio.h>

int main() {
	int n, i, cnt = 0;
	int arr[42] = { 0, };

	for (i = 0; i < 10; i++) {
		scanf("%d", &n);
		
		arr[n % 42]++;
	}

	for (i = 0; i < 42; i++) {
		if (arr[i] > 0)
			cnt++;
	}

	printf("%d\n", cnt);
}