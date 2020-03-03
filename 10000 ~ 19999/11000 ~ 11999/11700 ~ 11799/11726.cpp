#include <iostream>

using namespace std;

int arr[1001];

int main() {
	int N;
	cin >> N;

	arr[1] = 1;
	arr[2] = 2;

	for (int i = 3; i <= N; i++) {
		arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
	}

	cout << arr[N];

	return 0;
}