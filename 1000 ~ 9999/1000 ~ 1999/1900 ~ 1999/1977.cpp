#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int M, N;

	cin >> M >> N;

	int min = 99999;
	int sum = 0;

	for (int i = M; i <= N; i++) {
		if (sqrt(i) == (int)sqrt(i)) {
			if (min > i)
				min = i;

			sum += i;
		}
	}

	if (sum == 0)
		cout << -1;
	else
		cout << sum << endl << min;
}