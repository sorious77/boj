#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	int t = 0;

	while (true) {
		cin >> n;
		t++;

		if (n == 0)
			break;

		vector<int> v;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int num;
			cin >> num;

			sum += num;
			v.push_back(num);
		}

		int avg = sum / n;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (v[i] < avg)
				count += avg - v[i];
		}

		printf("Set #%d\n", t);
		printf("The minimum number of moves is %d.\n\n", count);
	}
}