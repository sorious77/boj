#include <iostream>
#include <math.h>

using namespace std;

int main() {
	int n;
	cin >> n;

	int res = pow(2, n);
	res = pow(1 + res, 2);
	cout << res;
}