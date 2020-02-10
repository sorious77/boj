#include <iostream>
#include <math.h>

using namespace std;

int main()
{
	int n, num[3];
	int cnt = 0;

	cin >> n;

	for (int i = 1; i <= n; i++) {
		if (i >= 1 && i < 100) {
			cnt++;
			continue;
		}
		if (i == 1000)
			continue;

		num[0] = i / 100;
		num[1] = (i % 100) / 10;
		num[2] = i % 10;

		if (num[0] - num[1] == num[1] - num[2])
			cnt++;
	}
	cout << cnt << endl;
}