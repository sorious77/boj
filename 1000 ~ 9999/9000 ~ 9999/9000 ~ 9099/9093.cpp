#include <iostream>
#include <string>

using namespace std;

int main() {
	string str;
	int test_case;
	cin >> test_case;
	getchar();

	for (int t = 0; t < test_case; t++) {
		string temp;
		getline(cin, str);

		for (int i = 0; i < str.length(); i++) {
			if (str[i] != ' ')
				temp.push_back(str[i]);
			else {
				for (int j = temp.length() - 1; j >= 0; j--)
					printf("%c", temp[j]);
				printf(" ");
				temp.clear();
			}
		}

		for (int j = temp.length() - 1; j >= 0; j--)
			printf("%c", temp[j]);
		printf("\n");
	}

	return 0;
}