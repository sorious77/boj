#include <iostream>

using namespace std;

int main() {
	long long n, m;
	scanf("%lld %lld", &n, &m);

	long long min, max;

	if (n > m) {
		min = m;
		max = n;
	}
	else {
		min = n;
		max = m;
	}

	long long temp;

	while (true) {
		if (max%min == 0)
			break;
		temp = max % min;
		max = min;
		min = temp;
	}
	
	for (long long i = 0; i < min; i++)
		cout << 1;
}