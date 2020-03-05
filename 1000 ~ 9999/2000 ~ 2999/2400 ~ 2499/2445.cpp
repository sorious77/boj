#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < i; j++) {
			printf("*");
		}
		for (int j = 2 * (n - i); j > 0; j--) {
			printf(" ");
		}
		for (int j = 0; j < i; j++) {
			printf("*");
		}
		printf("\n");
	}

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < n - i; j++) {
			printf("*");
		}
		for (int j = 0; j < 2 * i; j++) {
			printf(" ");
		}
		for (int j = 0; j < n - i; j++) {
			printf("*");
		}
		printf("\n");
	}
}