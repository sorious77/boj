#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;

	if (90 <= n && 100 >= n)
		printf("A\n");
	else if (80 <= n && 89 >= n)
		printf("B\n");
	else if (70 <= n && 79 >= n)
		printf("C\n");
	else if (60 <= n && 69 >= n)
		printf("D\n");
	else
		printf("F\n");
}