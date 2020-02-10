#include <iostream>
#include <cmath>

using namespace std;

int findSum(int n);

int main() {
	int num;

	cin >> num;

	int i;

	for (i = 1; i <= num; i++) {
		if (findSum(i) == num)
			break;
	}

	if (i == num + 1)
		cout << 0;
	else
		cout << i;
}

int findSum(int n) {
	int sum = n;
	char temp[10];

	sprintf(temp, "%d", sum);

	int index = 0;
	while (true) {
		if (temp[index] == '\0')
			break;

		sum += temp[index] - '0';
		index++;
	}

	return sum;
}