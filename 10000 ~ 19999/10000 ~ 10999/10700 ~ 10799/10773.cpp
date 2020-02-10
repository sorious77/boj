#include <iostream>
#include <stack>

using namespace std;


int main() {
	int k;
	cin >> k;

	stack<int> money;

	int temp, sum = 0;

	for (int i = 0; i < k; i++) {
		cin >> temp;
		if (temp == 0) {
			sum -= money.top();
			money.pop();
		}
		else {
			money.push(temp);
			sum += temp;
		}
	}
	cout << sum;
}