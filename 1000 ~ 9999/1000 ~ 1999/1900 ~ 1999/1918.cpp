#include <iostream>
#include <stack>
#include <string>

using namespace std;

stack <char> op;

int main() {
	string str;

	cin >> str;

	int count = 0;

	for (int i = 0; i < str.length(); i++) {
		if ('A' <= str[i] && str[i] <= 'Z') {
			cout << str[i];
		}
		else if (str[i] == ')') {
			while (!op.empty() && op.top() != '(') {
				cout << op.top();
				op.pop();
			}
			op.pop();
		}
		else if (str[i] == '(')
			op.push(str[i]);
		else if (str[i] == '*' || str[i] == '/') {
			while (!op.empty() && (op.top() == '*' || op.top() == '/')) {
				cout << op.top();
				op.pop();
			}
			op.push(str[i]);
		}
		else {
			while (!op.empty() && op.top() != '(') {
				cout << op.top();
				op.pop();
			}
			op.push(str[i]);
		}
	}

	while (!op.empty()) {
		cout << op.top();
		op.pop();
	}
}