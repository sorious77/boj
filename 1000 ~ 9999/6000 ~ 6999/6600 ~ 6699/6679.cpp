#include <iostream>

using namespace std;

int to_10(int num);
int to_12(int num);
int to_16(int num);

int main() {
	for (int i = 2992; i <= 9999; i++) {
		if (to_10(i) == to_12(i) && to_12(i) == to_16(i))
			printf("%d\n", i);
	}
}

int to_10(int num) {
	int res = 0;

	while (num >= 10) {
		res += num % 10;
		num /= 10;
	}

	res += num % 10;

	return res;
}

int to_12(int num) {
	int res = 0;

	while (num >= 12) {
		res += num % 12;
		num /= 12;
	}

	res += num % 12;

	return res;
}

int to_16(int num) {
	int res = 0;

	while (num >= 16) {
		res += num % 16;
		num /= 16;
	}

	res += num % 16;
	
	return res;
}