#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int index, int count);

int N, M;
vector<int> num;
vector<int> v;
bool visit[10001];

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
		visit[i] = true;
		dfs(i, 1);
		v.pop_back();
		visit[i] = false;
	}
}

void dfs(int index, int count) {
	if (count == M) {
		for (int i = 0; i < v.size(); i++)
			printf("%d ", v[i]);
		printf("\n");
		return;
	}

	for (int i = 0; i < num.size(); i++) {
		if (i != index && !visit[i]) {
			v.push_back(num[i]);
			visit[i] = true;
			dfs(i, count + 1);
			v.pop_back();
			visit[i] = false;
		}
	}
}