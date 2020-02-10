#include <iostream>

using namespace std;

int main() {
	unsigned long long n;
	cin >> n;

	unsigned long long *arr = new unsigned long long[n + 1];

	if (n == 0 || n == 1)
		cout << n << endl;

	else {
		arr[0] = 0; arr[1] = 1;

		for (unsigned long long i = 2; i <= n; i++)
			arr[i] = arr[i - 2] + arr[i - 1];

		cout << arr[n] << endl;
	}
}