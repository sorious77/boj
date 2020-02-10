#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s;

	while (true) {
		getline(cin, s, '\n');

		if (s == "END")
			break;
		
		for (int i = s.size()-1; i >= 0; i--) {
			cout << s[i];
		}
		cout << endl;
	}
}