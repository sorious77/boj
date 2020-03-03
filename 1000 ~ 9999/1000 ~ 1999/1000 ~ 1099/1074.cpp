#include <iostream>
#include <cmath>

using namespace std;

int N, R, C;

void solve(int start, int size, int x, int y);

int main() {
	cin >> N >> R >> C;

	int size = 1;
	for (int i = 0; i < N; i++)
		size *= 2;
	
	solve(0, size, 0, 0);

	return 0;
}

void solve(int start, int size, int x, int y) {
	size /= 2;

	int count = 0;

	if (C >= x + size) {
		x += size;
		count++;
	}
	
	if (R >= y + size) {
		y += size;
		count += 2;
	}

	if (size == 1) {
		cout << start + count;
		return;
	}

	int temp = pow(4, log2(size * 2) - 1);

	start = start + count * temp;

	solve(start, size, x, y);
}