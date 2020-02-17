#include <iostream>
#include <string>

using namespace std;

int main() {
	string str;
	bool check = true;
	int v_count = 0;
	int c_count = 0;
	bool vowel = false;

	while (true) {
		cin >> str;
		check = true; // true->can, false->can't
		vowel = false; // 모음이 나왔는지
		v_count = 0;
		c_count = 0;

		if (str == "end")
			break;

		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1) {
				if (str[i] == str[i + 1] && str[i] != 'e' && str[i] != 'o') {
					check = false;
					break;
				}
			}

			if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
				vowel = true;
				c_count = 0;
				v_count++;
			}
			else {
				c_count++;
				v_count = 0;
			}

			if (c_count >= 3 || v_count >= 3) {
				check = false;
				break;
			}
		}

		if (!check || !vowel)
			printf("<%s> is not acceptable.\n", str.c_str());
		else 
			printf("<%s> is acceptable.\n", str.c_str());
	}
}