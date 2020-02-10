#include <iostream>

using namespace std;

int main() {
	int t;
	int k, n, sum;
	int arr[15][15] = { 0 };

	cin >> t;

	for (int i = 1; i <= 14; i++) {
		arr[0][i] = i;
	}

	for (int i = 0; i < t; i++) {
		cin >> k >> n;
		
		for (int j = 1; j <= k; j++) {
			for (int l = 1; l <= n; l++) {
				arr[j][l] = arr[j - 1][l] + arr[j][l - 1];
			}
		}
		cout << arr[k][n] << endl;
	}
}