#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	string input;

	cin >> input;

	vector<string> v;

	string temp = "";

	for (int i = input.length() - 1; i >= 0; i--) {
		temp = input[i] + temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << "\n";
	}

	return 0;
}