#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int N, M;
bool visit[13] = { false, };
vector<pair<int, int>> house;
vector<pair<int, int>> chicken;

int ans = 9999999;

int bfs();
void dfs(int index, int size);

int main() {
	cin >> N >> M;

	int input;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> input;

			if (input == 1)
				house.push_back(make_pair(j, i));
			else if (input == 2)
				chicken.push_back(make_pair(j, i));
		}
	}

	dfs(0, 0);

	cout << ans;
}

void dfs(int index, int size) {
	if (index > chicken.size())
		return;

	if (size == M) {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int dist = 999999;
			for (int j = 0; j < chicken.size(); j++) {
				if (visit[j]) {
					dist = min(dist, abs(house[i].first - chicken[j].first) + abs(house[i].second - chicken[j].second));
				}
			}
			sum += dist;
		}

		ans = min(sum, ans);
		return;
	}

	visit[index] = true;
	dfs(index + 1, size + 1);
	visit[index] = false;
	dfs(index + 1, size);
}