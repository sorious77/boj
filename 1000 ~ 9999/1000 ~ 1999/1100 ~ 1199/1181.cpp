#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(string a, string b);

int main() {
	int n;

	vector<string> v;

	cin >> n;

	for (int i = 0; i < n; i++) {
		string input;
		cin >> input;

		if(find(v.begin(), v.end(), input) == v.end())
			v.push_back(input);
	}
	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << endl;
	}
}

bool compare(string a, string b) {
	if (a.length() == b.length()) {
		return a < b;
	}
	else
		return a.length() < b.length();
}