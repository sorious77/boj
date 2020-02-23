#include <iostream>
#include <vector>

using namespace std;

int main() {
	int N;

	cin >> N;

	vector<int> money;

	int input;
	int max = -1;

	for (int i = 0; i < N; i++) {
		cin >> input;
		money.push_back(input);
		
		if (max < input)
			max = input;
	}

	int max_money;
	cin >> max_money;

	int left = 0;
	int right = max;
	int res = 0;

	while (left <= right) {
		int mid = (left + right) / 2;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (money[i] < mid)
				sum += money[i];
			else
				sum += mid;
		}

		if (sum > max_money)
			right = mid - 1;
		else {
			left = mid + 1;
			res = mid;
		}
	}

	cout << res;
}