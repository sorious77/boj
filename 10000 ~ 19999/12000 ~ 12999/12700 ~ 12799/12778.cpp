#include <iostream>
#include <vector>

using namespace std;

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; ++t) {
		int m;
		char ch;
		cin >> m >> ch;

		if (ch == 'N') {
			vector<int> v;

			for (int i = 0; i < m; i++) {
				int temp;
				cin >> temp;
				v.push_back(temp);
			}

			for (int i = 0; i < m; i++) {
				printf("%c ", v[i] + 'A' - 1);
			}
		}
		else {
			vector<char> v;

			for (int i = 0; i < m; i++) {
				char temp;
				cin >> temp;
				v.push_back(temp);
			}

			for (int i = 0; i < m; i++) {
				cout << v[i] - 'A' + 1 << " ";
			}
		}

		cout << "\n";
	}
}