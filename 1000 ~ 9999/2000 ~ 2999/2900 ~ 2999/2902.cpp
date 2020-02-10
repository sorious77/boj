#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s, res = { 0 };

	getline(cin, s, '\n');

	res = s[0];
	
	for (int i = 1; i < s.size(); i++) {
		if (s[i] == '-')
			res += s[i + 1];
	}

	cout << res << endl;
}