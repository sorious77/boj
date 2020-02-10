#include <iostream>

using namespace std;

int main()
{
	int c, n, i, j, cnt=0;
	double s[1000], avg, sum;

	cin >> c;

	for (i = 0; i < c; i++) {
		cin >> n;
		sum = 0;
		cnt = 0;
		for (j = 0; j < n; j++) {
			cin >> s[j];
			sum += s[j];
		}
		avg = sum / n;

		for (j = 0; j < n; j++) {
			if (s[j] > avg)
				cnt++;
		}
		printf("%.3f%%\n", (float)cnt / n * 100);
	}
}