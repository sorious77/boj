#include <iostream>
#include <cstring>

using namespace std;

#define MAX 1000000

void findSosu();

bool arr[1000001];

int main() {
	int num;

	findSosu();

	while (true) {
		scanf("%d", &num);
		if (num == 0)
			break;

		bool check = false;

		for (int i = 3; i <= num / 2; i++) {
			if (arr[i] && arr[num - i]) {
				printf("%d = %d + %d\n", num, i, num - i);
				check = true;
				break;
			}
		}

		if (!check)
			printf("Goldbach's conjecture is wrong.\n");
	}

	return 0;
}

void findSosu() {
	memset(arr, true, sizeof(arr));

	arr[0] = arr[1] = false;

	for (int i = 2; i * i < MAX; i++) {
		if (arr[i]) {
			for (int j = i * i; j < MAX; j += i) {
				arr[j] = false;
			}
		}
	}
}