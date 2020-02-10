#include <iostream>

using namespace std;

int main()
{
	double max = 0, avg = 0;
	int i,n;

	cin >> n;

	double *s = new double[n];

	for (i = 0; i < n; i++) {
		cin >> s[i];
	}

	for (i = 0; i < n; i++) {
		if (s[i] > max)
			max = s[i];
	}

	for (i = 0; i < n; i++) {
		s[i] = s[i] / max * 100;
	}

	for (i = 0; i < n; i++) {
		avg += s[i];
	}

	delete []s;

	cout << avg / n;
}