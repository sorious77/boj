#include <iostream>

using namespace std;

int main() {
	int n, m;
	cin >> n >> m;

	int *arr = new int[n];

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	int max = -1, sum;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j)
				continue;
			for (int k = 0; k < n; k++) {
				if (i == k || j == k)
					continue;

				sum = arr[i] + arr[j] + arr[k];

				if (sum == m) {
					max = m;
					break;
				}

				if (m > sum && sum > max) {
					max = sum;
				}
			}
		}
	}

	cout << max << endl;
}