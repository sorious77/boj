#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	priority_queue<int, vector<int>, greater<int>> h;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;	

		if (num == 0) { // input 0
			if (h.empty()) // heap에 데이터가 없을 경우
				cout << "0\n";
			else {
				cout << h.top() << endl; // min값 print
				h.pop(); // pop
			}
		}
		else { // input num
			h.push(num);
		}
	}
}