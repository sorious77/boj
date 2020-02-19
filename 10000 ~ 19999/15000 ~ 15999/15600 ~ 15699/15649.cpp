#include <iostream>
#include <vector>

using namespace std;

int arr[8];
bool visit[8];
vector<int> v;

int N, M;

void dfs(int n, int count);

int main() {

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		arr[i] = i + 1;
	}

	for (int i = 0; i < N; i++) {
		v.push_back(arr[i]);
		visit[i] = true;
		dfs(i, 1);
		v.pop_back();
		visit[i] = false;
	}
}

void dfs(int n, int count) {
	if (count >= M) {
		for (int i = 0; i < v.size(); i++)
			printf("%d ", v[i]);
		printf("\n");
		return;
	}

	for (int i = 0; i < N; i++) {
		if (!visit[i]) {
			visit[i] = true;
			v.push_back(arr[i]);
			dfs(i, count + 1);
			v.pop_back();
			visit[i] = false;
		}
	}
}