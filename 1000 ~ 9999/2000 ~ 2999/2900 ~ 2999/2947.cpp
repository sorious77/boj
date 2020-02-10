#include <iostream>

using namespace std;

bool checkArr(int *arr) {
	for (int i = 0; i < 5; i++) {
		if (arr[i] != i + 1)
			return false;
	}
	return true;
}

void printArr(int *arr) {
	for (int i = 0; i < 5; i++) {
		cout << arr[i] << " ";
	}
	cout << endl;
}

int main() {
	int arr[5];

	for (int i = 0; i < 5; i++)
		cin >> arr[i];

	do{
		for (int i = 0; i < 4; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				printArr(arr);
			}
		}
	}while(!checkArr(arr));
}