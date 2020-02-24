#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int index, int count);

int N, M;
vector<int> num;
vector<int> v;

int main() {
	cin >> N >> M;

	int input;
	for (int i = 0; i < N; i++) {
		cin >> input;
		num.push_back(input);
	}

	sort(num.begin(), num.end());

	for (int i = 0; i < N; i++) {
		v.push_back(num[i]);
		dfs(i, 1);
		v.pop_back();
	}
}

void dfs(int index, int count) {
	if (count == M) {
		for (int i = 0; i < v.size(); i++)
			printf("%d ", v[i]);
		printf("\n");
		return;
	}

	for (int i = index + 1; i < num.size(); i++) {
		v.push_back(num[i]);
		dfs(i, count + 1);
		v.pop_back();
	}
}