#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int num[3];
	for (int i = 0; i < 3; i++) {
		cin >> num[i];
	}

	sort(num, num + 3);

	char str[4];
	cin >> str;

	for (int i = 0; i < 3; i++) {
		printf("%d ", num[str[i] - 'A']);
	}
}