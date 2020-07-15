#include <iostream>
#include <queue>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(false);
    
	int n;

	cin >> n;

	priority_queue<int, vector<int>, less<int>> max_heap;
	priority_queue<int, vector<int>, greater<int>> min_heap;

	bool flag = false;
    bool empty_flag = true;

	for (int i = 0; i < n; i++) {
		int input;

		cin >> input;

		if (!flag) {
			max_heap.push(input);
		}
		else {
			min_heap.push(input);
            empty_flag = false;
		}

		if (!empty_flag) {
			if (max_heap.top() > min_heap.top()) {
				int max_top = max_heap.top();
				int min_top = min_heap.top();

				max_heap.pop();
				min_heap.pop();

				max_heap.push(min_top);
				min_heap.push(max_top);
			}
		}

		cout << max_heap.top() << "\n";

		flag = !flag;
	}

	return 0;
}