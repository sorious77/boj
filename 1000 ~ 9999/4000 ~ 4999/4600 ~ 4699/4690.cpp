#include <iostream>

using namespace std;

int power(int num) {
	return num * num * num;
}

int main() {
	for (int i = 6; i <= 100; i++) {
		for (int j = 2; j < i; j++) {
			for (int k = j + 1; k < i; k++) {
				for (int l = k + 1; l < i; l++) {
					if (power(i) == power(j) + power(k) + power(l)) {
						printf("Cube = %d, Triple = (%d,%d,%d)\n", i, j, k, l);
					}
				}
			}
		}
	}
}