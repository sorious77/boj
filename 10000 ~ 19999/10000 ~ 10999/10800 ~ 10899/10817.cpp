#include <iostream>

using namespace std;

int main() {
	int arr[3];
	
	for (int i = 0; i < 3; i++)
		cin >> arr[i];

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

	cout << arr[1];
}