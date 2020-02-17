#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> number;
bool visit[13];
vector<int> print;

void dfs(int start, int size);

int main() {
	int n;

	while (true) {
		cin >> n;
		if (n == 0)
			break;

		number.clear();

		for (int i = 0; i < n; i++) {
			int input;
			cin >> input;

			number.push_back(input);
			visit[i] = false;
		}

		sort(number.begin(), number.end());

		for (int i = 0; i < n; i++) {
			dfs(i, 0);
			visit[i] = false;
			print.clear();
		}

		printf("\n");
	}
}

void dfs(int start, int size) {
	visit[start] = true;
	size++;
	print.push_back(number[start]);

	if (size >= 6) {
		for (int i = 0; i < print.size(); i++) {
			printf("%d ", print[i]);
		}
		printf("\n");
		return;
	}

	for (int i = start + 1; i < number.size(); i++) {
		if (!visit[i])
			dfs(i, size);

		visit[i] = false;
		print.pop_back();
	}
}