#include <iostream>

using namespace std;

int main() {
	int N;
	int res = -1;

	cin >> N;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;

		if (res < input)
			res = input;
	}

	cout << res << "\n";

	return 0;
}