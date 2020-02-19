#include <iostream>

using namespace std;

int fibo(int n);

int main() {
	int n;
	cin >> n;

	cout << fibo(n);
}

int fibo(int n) {
	if (n <= 1)
		return n;

	return fibo(n - 1) + fibo(n - 2);
}