#include <iostream>
#include <queue>
#include <string>

using namespace std;

int A, B;

void bfs();

int main() {
	int test_case;
	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		cin >> A >> B;

		bfs();
	}

	return 0;
}

void bfs() {
	bool visit[10000] = { false, };
	queue<pair<int, string>> q;

	q.push(make_pair(A, ""));
	visit[A] = true;

	while (!q.empty()) {
		int cur_num = q.front().first;
		string cur_str = q.front().second;
		q.pop();

		if (cur_num == B) {
			cout << cur_str << "\n";
		}

		// D
		if (!visit[cur_num * 2 % 10000]) {
			visit[cur_num * 2 % 10000] = true;
			q.push(make_pair(cur_num * 2 % 10000, cur_str + 'D'));
		}

		// S
		if (cur_num == 0) {
			if (!visit[9999]) {
				visit[9999] = true;
				q.push(make_pair(9999, cur_str + 'S'));
			}
		}
		else {
			if (!visit[cur_num - 1]) {
				visit[cur_num - 1] = true;
				q.push(make_pair(cur_num - 1, cur_str + 'S'));
			}
		}

		// L
		int temp = cur_num;
		temp = temp * 10 % 10000 + temp / 1000;
		if (!visit[temp]) {
			visit[temp] = true;
			q.push(make_pair(temp, cur_str + 'L'));
		}

		// R
		temp = cur_num;
		temp = temp / 10 + temp % 10 * 1000;
		if (!visit[temp]) {
			visit[temp] = true;
			q.push(make_pair(temp, cur_str + 'R'));
		}
	}
}