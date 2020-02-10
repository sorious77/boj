#include <iostream>
#include <string>

using namespace std;

int main() {
	string str;

	getline(cin, str);
	
	if (str[0] == ' ')
		str.erase(str.begin());

	if (str[str.length() - 1] == ' ')
		str.erase(str.end() - 1);

	if (str.length() == 0)
		cout << 0;
	else {
		int count = 0;
		int pos = 0;

		while ((pos = str.find(' ', pos)) != string::npos) {
			count++;
			pos += 1;
		}

		cout << count + 1;
	}
}