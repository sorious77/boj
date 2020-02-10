#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	
	cin >> n;

	int *arr = new int[n];

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	int b, c;
	cin >> b >> c;

	long long res = 0;

	for (int i = 0; i < n; i++) {
		int temp = arr[i];
		res++;
		temp -= b;

		if (temp > 0) {
			if (temp%c == 0)
				res += temp / c;
			else
				res += temp / c + 1;
		}
	}

	cout << res;
}