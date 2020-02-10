#include <iostream>
#include <stack>
#include <string>

using namespace std;


int main() {
	int n;
	cin >> n;

	stack<int> num;

	string op;

	for (int i = 0; i < n; i++) {
		cin >> op;

		if (op == "push") {
			int temp;
			cin >> temp;
			num.push(temp);
		}
		else if (op == "top") {
			if (num.empty()) {
				cout << -1 << endl;
				continue;
			}
			cout << num.top() << endl;
		}
		else if (op == "pop") {
			if (num.empty()) {
				cout << -1 << endl;
				continue;
			}
			cout << num.top() << endl;
			num.pop();
		}
		else if (op == "size") {
			cout << num.size() << endl;
		}
		else if (op == "empty") {
			if(num.empty())
				cout << 1 << endl;
			else
				cout << 0 << endl;
		}
	}
}