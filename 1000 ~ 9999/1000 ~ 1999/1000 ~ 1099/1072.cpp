#include <iostream>

using namespace std;

#define MAX 1000000000

int main() {
	long long x, y;
	int z;

	cin >> x >> y;

	z = (y * 100) / x;

	if (z >= 99) {
		cout << -1 << endl;
		return 0;
	}

	int left = 0;
	int right = MAX;

	int ans = -1;

	while (left <= right) {
		int mid = (left + right) / 2;

		int tempZ = ((y + mid) * 100) / (x + mid);

		if (z >= tempZ) {
			left = mid + 1;
			ans = left;
		}
		else
			right = mid - 1;
	}

	cout << ans << endl;
}