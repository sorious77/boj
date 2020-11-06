#include <iostream>
#include <queue>
#include <algorithm>

#define MAX_DIST 999999999

using namespace std;

int main() {
	int n, m;

	cin >> n >> m;

	int** arr = new int* [n + 1];
	int* dist = new int[n + 1];
	bool* visit = new bool[n + 1];

	for (int i = 1; i <= n; i++) {
		arr[i] = new int[n + 1];
		
		for (int j = 1; j <= n; j++) {
			arr[i][j] = MAX_DIST;
		}

		arr[i][i] = 0;
	}

	int start, end, weight;
	for (int i = 0; i < m; i++) {
		cin >> start >> end >> weight;

		arr[start][end] = weight;
	}

	cin >> start >> end;

	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

	for (int i = 1; i <= n; i++) {
		if (i != start)
			pq.push(make_pair(arr[start][i], i));

		dist[i] = arr[start][i];
		visit[i] = false;
	}

	visit[start] = true;
	dist[start] = 0;

	for (int i = 0; i < n - 1; i++) {
		pair<int, int> temp;

		while (true) {
			temp = pq.top();
			pq.pop();
			
			if (!visit[temp.second])
				break;
		}

		visit[temp.second] = true;

		for (int j = 1; j <= n; j++) {
			//if (!visit[j]) {
				dist[j] = min(dist[j], dist[temp.second] + arr[temp.second][j]);
				pq.push(make_pair(dist[j], j));
			//}
		}
	}

	cout << dist[end];
}