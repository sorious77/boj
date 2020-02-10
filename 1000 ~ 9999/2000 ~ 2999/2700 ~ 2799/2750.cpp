#include <iostream>

#define SWAP(A,B,TEMP) {TEMP=A; A=B; B=TEMP;}

using namespace std;

int main() {
	int n;
	int temp;

	cin >> n;

	int *arr = new int[n];

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++){
		if (i == 0)
			continue;

		if (arr[i] < arr[i - 1]) {
			SWAP(arr[i], arr[i - 1], temp);
			i = 0;
		}
	}

	for (int i = 0; i < n; i++) {
		cout << arr[i] << "\n";
	}

	delete(arr);
}