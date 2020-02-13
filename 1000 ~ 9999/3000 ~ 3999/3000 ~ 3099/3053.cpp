#define _USE_MATH_DEFINES
#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int r;

	cin >> r;

	printf("%.6lf\n%.6lf\n", r*r*M_PI, (double)2 * r * r);
}