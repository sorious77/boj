#include <iostream>

using namespace std;

int main() {
	int l, p;
	int num[5];

	cin >> l >> p;
	for (int i = 0; i < 5; i++)
		cin >> num[i];

	for (int i = 0; i < 5; i++) {
		printf("%d ", num[i] - l * p);
	}
}