#include <iostream>
#include <vector>

using namespace std;

int main() {
	int N, K;
	int index;
	vector<int> coin;

	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;

		coin.push_back(input);

		if (input <= K)
			index = i;
	}

	int res = 0;
	for (int i = index; i >= 0; i--) {
		res += K / coin[i];
		K %= coin[i];

		if (K == 0)
			break;
	}

	cout << res;

	return 0;
}