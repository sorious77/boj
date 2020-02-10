#include <iostream>
#include <cstring>
#include <stack>

using namespace std;

int main() {
	char str[102];

	stack<char> paren;

	int size, check = 1;

	while (true) {
		fgets(str, sizeof(str), stdin);
		if (!strcmp(str, ".\n"))
			break;

		check = 1;

		for (int i = 0; i < strlen(str); i++) {
			if (str[i] == '(')
				paren.push('(');
			else if (str[i] == ')') {
				if (paren.empty() || paren.top() == '[') {
					check = 0;
					break;
				}
				else
					paren.pop();
			}
			else if (str[i] == '[')
				paren.push('[');
			else if (str[i] == ']') {
				if (paren.empty() || paren.top() == '(') {
					check = 0;
					break;
				}
				else
					paren.pop();
			}
			else if (str[i] == '.')
				break;
		}

		if (!paren.empty())
			check = 0;

		size = paren.size();
		for (int i = 0; i < size; i++) paren.pop();

		if (check == 1)
			cout << "yes" << endl;
		else
			cout << "no" << endl;
	}
}