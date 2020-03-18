#include <iostream>
#include <string>

using namespace std;

void solve();

int main() {
	solve();

	return 0;
}

void solve() {
	int test_case;
	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		int n;
		int price, max = -1;
		string name, res;

		cin >> n;

		for (int i = 0; i < n; i++) {
			cin >> price >> name;

			if (price > max) {
				max = price;
				res = name;
			}
		}

		cout << res << "\n";
	}
}