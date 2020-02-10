#include <iostream>
#include <string>

using namespace std;

int main() {
	string str;
	int n, score, cnt;
	cin >> n;

	getc(stdin);

	for (int i = 0; i < n; i++) {
		getline(cin,str);
		score = 0;
		cnt = 1;

		for (int j = 0; j < str.length(); j++) {
			if (str[j] == 'O') {
				score += cnt;
				cnt++;
			}
			else
				cnt = 1;
		}
		cout << score << endl;
	}
}