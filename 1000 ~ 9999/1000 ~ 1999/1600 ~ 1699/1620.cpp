#include <iostream>
#include <string>
#include <map>
#include <cctype>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, m;
	cin >> n >> m;

	vector<string> num;
	map<string, int> name; // name, index

	string input;
	for (int i = 0; i < n; i++) {
		cin >> input;

		num.push_back(input);
		name.insert(make_pair(input, i + 1));
	}

	for (int i = 0; i < m; i++) {
		cin >> input;

		if (isdigit(input[0])) { // 숫자로 들어오면 그냥 print
			cout << num[stoi(input) - 1] << "\n";
		}
		else {
			cout << name[input] << "\n";
		}
	}
}