#include <iostream>

using namespace std;

bool checkSosu(int num);

int main() {
	int n, m, sum = 0, min = 99999;

	cin >> n >> m;

	for (int i = n; i <= m; i++) {
		if (checkSosu(i)) {
			if (i < min)
				min = i;
			sum += i;
		}
	}
	if (min == 99999)
		printf("-1");
	else
		printf("%d\n%d\n",sum,min);
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