#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	int t;
	cin >> t;

	for (int i = 0; i < t; i++) {
		int n;
		int index = -1;
		cin >> n;
		vector<string> word;

		string input;
		for (int j = 0; j < n; j++) {
			cin >> input;
			word.push_back(input);

			if ('a' <= input[0] && input[0] <= 'z')
				index = j;
		}

		if (index != -1) {
			for (int j = index + 1; j < word.size(); j++) {
				printf("%s ", word[j].c_str());
			}
			printf("%s ", word[index].c_str());
			for (int j = 0; j < index; j++) {
				printf("%s ", word[j].c_str());
			}
			printf("\n");
		}
		else {
			for (int j = 0; j < word.size(); j++) {
				printf("%s ", word[j].c_str());
			}
			printf("\n");
		}
	}
}