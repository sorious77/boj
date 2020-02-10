#include <iostream>
#include <cstring>

using namespace std;

int main() {
	int n;
	cin >> n;

	char str[50];
	for (int i = 0; i < n; i++) {
		cin >> str;

		cout << "String #" << i + 1 << endl;

		for (int j = 0; j < strlen(str); j++) {
			if (str[j] == 'Z')
				cout << 'A';
			else
				printf("%c", str[j] + 1);
		}
		cout << endl << endl;
	}
}