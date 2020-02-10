#include <iostream>
#include <stack>
#include <cstring>

using namespace std;


int main() {
	int n;
	cin >> n;
	getchar();

	stack<char> paren;

	char temp[50];
	int res = 1;

	for (int i = 0; i < n; i++) {
		res = 1;
		cin >> temp;
		
		for (int j = 0; j < strlen(temp); j++) {
			if (temp[j] == '(')
				paren.push('(');
			else if (temp[j] == ')') {
				if (paren.empty()) {
					res = 0;
					break;
				}
				else
					paren.pop();
			}
		}

		if (!paren.empty())
			res = 0;

		int size = paren.size();
		for (int j = 0; j < size; j++)
			paren.pop();

		if (res == 1) {
			cout << "YES" << endl;
		}
		else
			cout << "NO" << endl;
	}
}