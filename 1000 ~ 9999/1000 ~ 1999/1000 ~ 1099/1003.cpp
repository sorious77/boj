#include <iostream>

using namespace std;

int main() {
	int n, m;
	cin >> n;

	int fib[41][2] = { {1,0},{0,1} };

	for (int i = 2; i <= 40; i++) {
		fib[i][0] = fib[i - 2][0] + fib[i - 1][0];
		fib[i][1] = fib[i - 2][1] + fib[i - 1][1];
	}

	for (int i = 0; i < n; i++) {
		cin >> m;
		printf("%d %d\n", fib[m][0], fib[m][1]);
	}
}