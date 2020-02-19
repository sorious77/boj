#include <iostream>
#include <string>

using namespace std;

int main() {
	string input;
	string s, e;

	while (true) {
		cin >> s;

		if (s == "ENDOFINPUT")
			break;

		getchar();

		getline(cin, input);
		cin >> e;

		for (int i = 0; i < input.length(); i++) {
			if ('F' <= input[i] && input[i] <= 'Z')
				printf("%c", (input[i] - 'A' - 5) % 26 + 'A');
			else if ('A' <= input[i] && input[i] <= 'E')
				printf("%c", (input[i] - 'A' - 5 + 26) % 26 + 'A');
			else
				printf("%c", input[i]);
		}
		cout << endl;
	}
}