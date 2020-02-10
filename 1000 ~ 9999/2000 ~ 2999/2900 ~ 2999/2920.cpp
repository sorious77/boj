#include <iostream>
#include <string>

using namespace std;

string printRes(int *arr) {
	if (arr[0] == 1) {
		for (int i = 0; i < 8; i++) {
			if (arr[i] != i + 1)
				return "mixed";
		}
		return "ascending";
	}
	else if (arr[0] == 8) {
		for (int i = 0; i < 8; i++) {
			if (arr[i] != 8 - i)
				return "mixed";
		}
		return "descending";
	}
	else
		return "mixed";
}

int main() {
	int arr[8];

	for (int i = 0; i < 8; i++) {
		cin >> arr[i];
	}

	cout << printRes(arr);
}