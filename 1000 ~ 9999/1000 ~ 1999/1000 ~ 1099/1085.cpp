#include <iostream>
#include <math.h>

using namespace std;

int main() {
	int x, y, w, h;

	cin >> x >> y >> w >> h;

	int min = 9999;

	if (min > abs(x))
		min = abs(x);
	if (min > abs(w - x))
		min = abs(w - x);
	if (min > abs(y))
		min = y;
	if (min > abs(h - y))
		min = abs(h - y);

	cout << min;
}