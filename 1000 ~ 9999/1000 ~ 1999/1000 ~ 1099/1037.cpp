#include <iostream>

using namespace std;

#define SWAP(A,B,TEMP) {TEMP=A; A=B; B=TEMP;}

int main() {
	int n, temp;

	cin >> n;

	int *arr = new int[n];

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] < arr[j])
				SWAP(arr[i], arr[j], temp);
		}
	}
	cout << arr[n - 1] * arr[0] << endl;
}