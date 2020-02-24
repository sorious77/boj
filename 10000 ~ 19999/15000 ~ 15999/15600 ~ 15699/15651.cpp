#include <iostream>
#include <vector>

using namespace std;

void dfs(int num, int count);

int N, M;
vector<int> v;

int main() {
	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		v.push_back(i);
		dfs(i, 1);
		v.pop_back();
	}
}

void dfs(int num, int count) {
	if (count == M) {
		for (int i = 0; i < v.size(); i++)
			printf("%d ", v[i]);
		printf("\n");
		return;
	}

	for (int i = 1; i <= N; i++) {
		v.push_back(i);
		dfs(i, count + 1);
		v.pop_back();
	}
}