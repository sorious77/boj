#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int visit[10001] = { 0, };

int N, M;
vector<int> num;
vector<int> v;

void dfs(int count);

int main() {
	cin >> N >> M;

	int input;
	for (int i = 0; i < N; i++) {
		cin >> input;
		if(visit[input] == 0)
			num.push_back(input);
		visit[input]++;
	}

	sort(num.begin(), num.end());

	for (int i = 0; i < num.size(); i++) {
		v.push_back(num[i]);
		dfs(1);
		v.pop_back();
	}
}

void dfs(int count) {
	if (count == M) {
		for (int i = 0; i < M; i++)
			printf("%d ", v[i]);
		printf("\n");
		return;
	}

	for (int i = 0; i < num.size(); i++) {
		v.push_back(num[i]);
		dfs(count + 1);
		v.pop_back();
	}
}