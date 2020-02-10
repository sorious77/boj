#include <iostream>
#include <string>

using namespace std;

bool isBig(char c);

int main() {
	string input;
	int cnt[26] = { 0, };

	cin >> input;

	for (int i = 0; i < input.size(); i++) {
		if (isBig(input[i]))
			cnt[input[i] - 'A']++;
		else
			cnt[input[i] - 'a']++;
	}
	int max = -1, idx = 0;
	bool check = false;
	for (int i = 0; i < 26; i++) {
		if (max != 0 && max == cnt[i])
			check = true;

		if (cnt[i] > max) {
			max = cnt[i];
			idx = i;
			check = false;
		}
	}
	if (check)
		cout << "?" << endl;
	else
		printf("%c\n", idx + 'A');
}

bool isBig(char c) {
	if (c >= 'a' && c <= 'z')
		return false;
	
	return true;
}