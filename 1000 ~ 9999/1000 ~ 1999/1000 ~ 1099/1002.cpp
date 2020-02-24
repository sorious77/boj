#include <iostream>

using namespace std;

int main() {
	int x1, x2, y1, y2, r1, r2;

	int test_case;
	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		int d = (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);

		int sub = (r2 - r1) * (r2 - r1);
		int sum = (r2 + r1) * (r2 + r1);

		if (d == 0) {
			if (sub == 0)
				printf("-1\n");
			else
				printf("0\n");
		}
		else if (d == sum || d == sub)
			printf("1\n");
		else if (sub < d && d < sum)
			printf("2\n");
		else
			printf("0\n");
	}
}