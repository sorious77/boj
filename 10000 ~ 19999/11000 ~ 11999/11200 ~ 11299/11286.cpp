#include <iostream>
#include <queue>

using namespace std;

priority_queue<int, vector<int>, less<int>> n;
priority_queue<int, vector<int>, greater<int>> p;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);

	int N;
	cin >> N;

	vector<int> print;

	int input;
	for (int i = 0; i < N; i++) {
		cin >> input;

		if (input < 0)
			n.push(input);
		else if(input > 0)
			p.push(input);
		else {
			if (n.empty() && p.empty()) {
				print.push_back(0);
			}
			else if (n.empty()) {
				print.push_back(p.top());
				p.pop();
			}
			else if (p.empty()) {
				print.push_back(n.top());
				n.pop();
			}
			else {
				if (n.top() * -1 <= p.top()) {
					print.push_back(n.top());
					n.pop();
				}
				else {
					print.push_back(p.top());
					p.pop();
				}
			}
		}

	}
	for (int i = 0; i < print.size(); i++) {
		cout << print[i] << "\n";
	}
}