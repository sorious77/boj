#include <iostream>
#include <deque>
#include <string>

using namespace std;

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
	deque<int> dq;

	int n, data;
	cin >> n;

	string op;

	for (int i = 0; i < n; i++) {
		cin >> op;

		if (op == "push") {
			cin >> data;
			dq.push_back(data);
		}
		else if (op == "pop") {
			if (dq.empty()) {
				cout << "-1\n";
			}
			else {
				cout << dq.front() << "\n";
				dq.pop_front();
			}
		}
		else if (op == "size") {
			cout << dq.size() << "\n";
		}
		else if (op == "empty") {
			cout << dq.empty() << "\n";
		}
		else if (op == "front") {
			if (dq.empty()) {
				cout << "-1\n";
			}
			else {
				cout << dq.front() << "\n";
			}
		}
		else {
			if (dq.empty()) {
				cout << "-1\n";
			}
			else {
				cout << dq.back() << "\n";
			}
		}
	}
	return 0;
}