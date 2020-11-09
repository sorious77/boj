#include <iostream>

using namespace std;
using ll = long long;

ll new_pow(int a, int b, int c) {
	if (b == 0)
		return 1;

	ll temp = new_pow(a, b / 2, c);

	if (b % 2 == 0) {
		return temp * temp % c;
	}
	else {
		return (temp * temp % c) * a % c;
	}
}

int main() {
	int a, b, c;
	cin >> a >> b >> c;

	cout << new_pow(a, b, c);

	return 0;
}