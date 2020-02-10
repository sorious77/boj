#include <iostream>

using namespace std;

int main()
{
	char s[100];
	bool check;
	cin >> s;

	for (int i = 0; i < 26; i++) {
		check = false;
		int j = 0;
		while (true) {
			if (s[j] == NULL)
				break;
			if ('a' + i == s[j]) {
				cout << j << " ";
				check = true;
				break;
			}
			j++;
		}
		if (check == false)
			cout << -1 << " ";
	}
}