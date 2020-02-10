#include <iostream>
#include <string>

using namespace std;

int main() {
	string n;
	int max = 0;
	int arr[10] = { 0, };
	getline(cin, n);

	for (int i = 0; i < n.length(); i++) {
		arr[n[i] - '0'] ++;
	}

	arr[6] = (arr[6] + arr[9]+1)/2;
	arr[9] = 0;

	for (int i = 0; i < 10; i++) {
		if (max < arr[i])
			max = arr[i];
	}

	cout << max;
}