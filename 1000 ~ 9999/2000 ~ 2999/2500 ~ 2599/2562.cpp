#include <iostream>

using namespace std;

int main() {
	int arr[9], idx;

	for (int i = 0; i < 9; i++) {
		cin >> arr[i];
	}

	int max = arr[0];
	idx = 0;

	for (int i = 1; i < 9; i++) {
		if (max < arr[i]) {
			max = arr[i];
			idx = i;
		}
	}

	printf("%d\n%d", max, idx + 1);
}