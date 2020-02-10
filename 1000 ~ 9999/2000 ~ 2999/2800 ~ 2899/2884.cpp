#include <iostream>

using namespace std;

int main() {
	int h, m;

	cin >> h >> m;

	if (m >= 45)
		printf("%d %d", h, m - 45);
	else {
		if (h == 0)
			printf("23 %d", m + 60 - 45);
		else
			printf("%d %d", h - 1, m + 60 - 45);
	}
}