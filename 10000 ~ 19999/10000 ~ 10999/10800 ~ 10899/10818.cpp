#include <iostream>

using namespace std;

int main() {
	int n, min, max;
	int input;

	cin >> n;
	
	cin >> input;
	min = input;
	max = input;
	
	for (int i = 1; i < n; i++) {
		cin >> input;

		if (input > max)
			max = input;

		if (input < min)
			min = input;
	}

	printf("%d %d", min, max);
}