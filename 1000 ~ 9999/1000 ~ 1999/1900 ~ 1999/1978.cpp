#include <iostream>

using namespace std;

bool checkSosu(int num);

int main() {
	int n, num, cnt = 0;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> num;
		if (checkSosu(num))
			cnt++;
	}

	cout << cnt;
}

bool checkSosu(int num) {
	if (num == 1)
		return false;
	for (int i = 2; i < num; i++) {
		if (num%i == 0)
			return false;
	}
	return true;
}