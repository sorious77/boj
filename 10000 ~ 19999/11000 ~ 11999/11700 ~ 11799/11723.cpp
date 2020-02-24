#include <iostream>
#include <string>
#include <cstring>

using namespace std;

bool arr[21];

int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);

	int m;

	cin >> m;

	for (int i = 0; i < m; i++) {
		string op;
		int num;

		cin >> op;

		if (op == "add") {
			cin >> num;

			arr[num] = true;
		}
		else if (op == "remove") {
			cin >> num;

			arr[num] = false;
		}
		else if (op == "check") {
			cin >> num;

			if (arr[num])
				cout << 1 << "\n";
			else
				cout << 0 << "\n";
		}
		else if (op == "toggle") {
			cin >> num;

			arr[num] = !arr[num];
		}
		else if (op == "all") {
			memset(arr, true, sizeof(arr));
		}
		else {
			memset(arr, false, sizeof(arr));
		}
	}
}