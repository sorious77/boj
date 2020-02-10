#include <iostream>

using namespace std;

int main() {
	int t;
	int h, w, n;
	int x, y;

	cin >> t;

	for (int i = 0; i < t; i++) {
		x = 0;
		y = 1;
		cin >> h >> w >> n;
		for (int j = 0; j < n; j++) {
			x++;
			if (x > h) {
				x = 1;
				y++;
			}
		}
		cout << x * 100 + y << endl;
	}
}