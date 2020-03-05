#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, S;
vector<int> num;
vector<int> v;
int res = 0;
bool visit[21] = { false, };

void dfs(int index, int size, int max_size);

int main() {
	cin >> N >> S;

	int input;

	for (int i = 0; i < N; i++) {
		cin >> input;

		if (input == S)
			res++;
		num.push_back(input);
	}

	for (int i = 2; i <= N; i++) {
		dfs(0, 0, i);
	}

	cout << res << "\n";

	return 0;
}

void dfs(int index, int size, int max_size) {
	if (size == max_size) {
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			sum += v[i];
		}
		if (sum == S)
			res++;

		return;
	}

	for (int i = index; i < N; i++) {
		if (!visit[i]) {
			visit[i] = true;
			v.push_back(num[i]);
			dfs(i + 1, size + 1, max_size);
			v.pop_back();
			visit[i] = false;
		}
	}
}