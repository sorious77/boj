#include <iostream>

using namespace std;

int getBag(int n);

int main()
{
	int n, bag;

	cin >> n;

	if (n == 4 || n == 7)
		bag = -1;
	else
		bag = getBag(n);

	cout << bag;
}

int getBag(int n) {
	int bag;

	if (n % 5 == 0)
		bag = n / 5;
	else if (n % 5 == 1)
		bag = (n - 6) / 5 + 2;
	else if (n % 5 == 2)
		bag = (n - 12) / 5 + 4;
	else if (n % 5 == 3)
		bag = n / 5 + n % 5 / 3;
	else if (n % 5 == 4)
		bag = (n - 9) / 5 + 3;

	return bag;
}