#include <iostream>

using namespace std;

void selfNumber(int num, int *arr);

int main()
{
	int arr[10000] = { 0, };

	for (int i = 0; i < 10000; i ++ ) {
		selfNumber(i, arr);
	}

	for (int i = 0; i < 10000; i++)
		if (arr[i] == 0)
			printf("%d\n", i);
}

void selfNumber(int num, int *arr) {
	int sum = num, div = 1;
	for (int i = 0; i < 4; i++) {
		sum += (num / div) % 10;
		div *= 10;
	}

	if (sum >= 10000)
		return;

	arr[sum] = 1;
}