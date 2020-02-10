#include <iostream>

using namespace std;

int findMin(int a, int b);

int main() {
	int n, m;
	scanf("%d:%d", &n, &m);

	int min = findMin(n, m);

	for (int i = min; i >= 2; i--) {
		if (n%i == 0 && m%i == 0) {
			n /= i;
			m /= i;
			i++;
		}
	}
	printf("%d:%d", n, m);
}

int findMin(int a, int b) {
	if (a > b)
		return a;
	else
		return b;
}