#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s;
	int cnt = 0;

	getline(cin, s, '\n');
	
	for (int i = 0; i < s.size(); i++) {
		switch (s[i]) {
		case 'c': {
			if (s[i + 1] && (s[i + 1] == '=' || s[i + 1] == '-'))
				i++;
			break;
			}
		case 'd':
			if ((s[i + 1] && s[i + 2]) && (s[i + 1] == 'z' && s[i + 2] == '='))
				i += 2;
			else if (s[i + 1] && s[i + 1] == '-')
				i++;
			break;
		case 'l':
			if (s[i + 1] && s[i + 1] == 'j')
				i++;
			break;
		case 'n':
			if (s[i + 1] && s[i + 1] == 'j')
				i++;
			break;
		case 's':
			if (s[i + 1] && s[i + 1] == '=')
				i++;
			break;
		case 'z':
			if (s[i + 1] && s[i + 1] == '=')
				i++;
			break;
		}
		cnt++;
	}
	cout << cnt;
}