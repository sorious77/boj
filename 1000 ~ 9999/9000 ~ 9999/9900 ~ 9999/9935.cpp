#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	string str;
	string boom;

	cin >> str >> boom;
	
	vector<char> ans;
	int index = 0;

	for (int i = 0; i < str.length(); i++) {
		ans.push_back(str[i]);
		index++;

		if (ans[index - 1] == boom[boom.length() - 1]) {
			bool check = true;

			for (int j = 0; j < boom.length(); j++) {
				if (ans[index - boom.length() + j] != boom[j]) {
					check = false;
					break;
				}
			}

			if (check) {
				index -= boom.length();
				for (int j = 0; j < boom.length(); j++)
					ans.pop_back();
			}
		}
	}

	if (ans.empty())
		cout << "FRULA" << "\n";
	else {
		for (auto it = ans.begin(); it != ans.end(); it++)
			cout << *it;
	}

	return 0;
}