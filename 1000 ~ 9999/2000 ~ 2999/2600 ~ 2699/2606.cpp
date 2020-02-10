#include <iostream>
#include <queue>

using namespace std;

int N, V;

vector<int> node[101];
bool visit[101];

void dfs(int num);

int main() {
	cin >> N >> V;

	int start, end;
	for (int i = 0; i < V; i++) {
		cin >> start >> end;

		node[start].push_back(end);
		node[end].push_back(start);
	}
	
	for (int i = 1; i <= N; i++) {
		visit[i] = false;
	}

	dfs(1);

	int count = 0;
	for (int i = 2; i <= N; i++) {
		if (visit[i])
			count++;
	}

	cout << count;
}

void dfs(int num) {
	visit[num] = true;

	for (int i = 0; i < node[num].size(); i++) {
		if (!visit[node[num][i]])
			dfs(node[num][i]);
	}
}