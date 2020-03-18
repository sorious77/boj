#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> name;
int n;
bool check[51] = { false, };

void input();
void solve();

int main() {
	input();
	solve();

	return 0;
}

void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		string temp;
		cin >> temp;

		name.push_back(temp);
	}
}

void solve() {
	int len = name[0].length();

	for (int i = 0; i < len; i++) {
		for (int j = 0; j < n - 1; j++) {
			if (name[j][i] != name[j + 1][i]) {
				check[i] = true;
				break;
			}
		}
	}

	for (int i = 0; i < len; i++) {
		if (check[i])
			cout << '?';
		else
			cout << name[0][i];
	}
	cout << "\n";
}