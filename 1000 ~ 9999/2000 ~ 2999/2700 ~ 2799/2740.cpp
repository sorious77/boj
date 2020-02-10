#include <iostream>

using namespace std;

int main() {
	int n, m, k;

	cin >> n >> m;

	int **arr1 = new int*[n];

	for (int i = 0; i < n; i++) {
		arr1[i] = new int[m];
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++) {
			cin >> arr1[i][j];
		}
	}

	cin >> m >> k;

	int **arr2 = new int*[m];

	for (int i = 0; i < m; i++) {
		arr2[i] = new int[k];
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < k; j++)
			cin >> arr2[i][j];
	}

	int **res = new int*[n];
	for (int i = 0; i < n; i++) {
		res[i] = new int[k];

		for (int j = 0; j < k; j++) {
			res[i][j] = 0;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			for (int q = 0; q < m; q++)
				res[i][j] += arr1[i][q] * arr2[q][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++)
			printf("%d ", res[i][j]);
		cout << endl;
	}
}