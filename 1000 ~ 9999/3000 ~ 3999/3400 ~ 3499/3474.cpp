#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int t;
	cin >> t;

	for (int i = 0; i < t; i++) {
		int num;

		cin >> num;

		int two = 0;
		int five = 0;

		for (int i = 2; i <= num; i *= 2)
			two += num / i;
		for (int i = 5; i <= num; i *= 5)
			five += num / i;

		cout << min(two, five) << endl;
	}
}