#include <iostream>

using namespace std;

int main() {
	int N;
	cin >> N;

	int input;
	int sum = 0;
	for (int i = 0; i < N; i++) {
		cin >> input;
		sum += input;
	}

	cout << sum - N + 1;
}