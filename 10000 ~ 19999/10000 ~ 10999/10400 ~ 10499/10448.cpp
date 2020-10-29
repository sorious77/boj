#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
	vector<int> triangle;

	for (int i = 1;; i++) {
		int temp = i * (i + 1) / 2;

		if (temp > 1000)
			break;
		triangle.push_back(temp);
	}

	int test_case;
	cin >> test_case;

	for (int t = 0; t < test_case; ++t) {
		int num;
		cin >> num;

		int last = 0;
		bool finish = false;

		for (int i = 0; i < triangle.size(); i++) {
			if (triangle[i] < num)
				last = i;
		}

		queue<pair<vector<int>, int>> q;

		vector<int> v;

		q.push(make_pair(v, 0));

		while (!q.empty()) {
			vector<int> temp = q.front().first;
			int index = q.front().second;
			q.pop();

			if (temp.size() == 3) {
				int sum = 0;

				for (int i = 0; i < 3; i++) {
					sum += temp[i];
				}

				if (sum == num) {
					finish = true;
					break;
				}
				continue;
			}

			for (int i = index; i <= last; i++) {
				vector<int> pushOne = temp;

				pushOne.push_back(triangle[i]);
				q.push(make_pair(pushOne, i));
			}
		}

		if (finish)
			cout << "1\n";
		else
			cout << "0\n";
	}
}