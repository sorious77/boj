#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> height;
vector<int> print;

bool visit[9] = { false, };

bool finish = false;

void dfs(int index, int sum);

int main() {
	int input;
	for (int i = 0; i < 9; i++) {
		cin >> input;
		height.push_back(input);
	}

	sort(height.begin(), height.end());

	for (int i = 0; i < 3; i++) {
		print.push_back(height[i]);
		dfs(i, height[i]);
		print.pop_back();

		if (finish)
			break;
	}
}

void dfs(int index, int sum) {
	if (sum == 100) {
		for (int i = 0; i < print.size(); i++)
			printf("%d\n", print[i]);
		finish = true;
		return;
	}

	for (int i = index + 1; i < 9; i++) {
		if (finish)
			return;

		if (print.size() <= 6) {
			print.push_back(height[i]);
			dfs(i, sum + height[i]);
			print.pop_back();
		}
	}
}