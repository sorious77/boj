#include <iostream>
#include <vector>

using namespace std;

int main() {
	int x_arr[1001] = { 0, };
	int y_arr[1001] = { 0, };

	vector<int> x_v;
	vector<int> y_v;
	
	for (int i = 0; i < 3; i++) {
		int x, y;
		cin >> x >> y;

		x_arr[x]++;
		y_arr[y]++;

		x_v.push_back(x);
		y_v.push_back(y);
	}
	
	int x, y;
	for (int i = 0; i < 3; i++) {
		if (x_arr[x_v[i]] == 1)
			x = x_v[i];
		if (y_arr[y_v[i]] == 1)
			y = y_v[i];
	}

	printf("%d %d", x, y);
}