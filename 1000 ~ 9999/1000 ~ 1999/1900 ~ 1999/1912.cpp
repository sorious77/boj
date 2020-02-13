#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> v;

	int max = -1001;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;

		if (max < num)
			max = num;

		v.push_back(num);
	}

	if (max <= 0) { // 숫자의 최댓값이 0보다 작은 경우, 최댓값이 수열의 합의 최댓값
		cout << max;
		return 0;
	}

	vector<int> sum;

	sum.push_back(v[0]);
	max = v[0];

	for (int i = 1; i < n; i++) {
		if (v[i] < 0) {
			if (sum[i - 1] + v[i] < 0)
				sum.push_back(0);
			else
				sum.push_back(sum[i - 1] + v[i]);
		}
		else
			sum.push_back(sum[i - 1] + v[i]);

		if (sum[i] > max)
			max = sum[i];
	}

	cout << max;
}