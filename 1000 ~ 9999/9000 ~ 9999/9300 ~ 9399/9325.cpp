#include <iostream>

using namespace std;

int main() {
	int n, car, optionNum, sum;
	cin >> n;

	for (int i = 0; i < n; i++) {
		sum = 0;
		cin >> car;
		sum += car;
		cin >> optionNum;
		for (int j = 0; j < optionNum; j++) {
			int t1, t2;
			cin >> t1 >> t2;
			sum += t1 * t2;
		}
		cout << sum << endl;
	}
}