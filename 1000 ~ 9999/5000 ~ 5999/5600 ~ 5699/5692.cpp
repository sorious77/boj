#include <iostream>
#include <cstring>

using namespace std;

void fac(int *arr);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	char str[6] = "1";
	int arr[10];

	fac(arr);

	int sum;

	while (true) {
		cin >> str;
		if (!strcmp(str, "0"))
			break;
		sum = 0;
		for (int i = 0; i < strlen(str); i++) {
			sum += (str[i] - '0') * arr[strlen(str) - i];
		}
		printf("%d\n", sum);
	}
}

void fac(int *arr) {
	arr[0] = 1;
	arr[1] = 1;
	for (int i = 2; i <= 9; i++) {
		arr[i] = arr[i - 1] * i;
	}
}