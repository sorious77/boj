#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

#define MAX_DIST 999999999

struct compare {
	bool operator()(pair<int, int> a, pair<int, int> b) {
		return a.first > b.first;
	}
};


struct Vertex {
	int point;
	int weight;
	Vertex* next;

	Vertex() {
		point = 0;
		weight = 0;
		next = nullptr;
	}

	Vertex(int point, int weight, Vertex* next) {
		this->point = point;
		this->weight = weight;
		this->next = next;
	}
};

int main() {
	int V, E;
	int v, u, w;
	int start;

	cin >> V >> E >> start;

	Vertex* vertex = new Vertex[V + 1];

	int dist[200001];
	bool visit[200001] = { false, };

	for (int i = 1; i <= V; i++) {
		dist[i] = MAX_DIST;
	}

	for (int i = 0; i < E; i++) {
		cin >> u >> v >> w;

		vertex[u].next = new Vertex(v, w, vertex[u].next);
	}

	dist[start] = 0;

	priority_queue<pair<int, int>, vector<pair<int, int>>, compare> pq;

	pq.push(make_pair(0, start));

	while (!pq.empty()) {
		pair<int, int> cur = pq.top();
		pq.pop();

		if (visit[cur.second])
			continue;

		visit[cur.second] = true;

		for (auto temp = vertex[cur.second].next; temp != nullptr; temp = temp->next) {
			if (!visit[temp->point]) {
				dist[temp->point] = min(dist[temp->point], dist[cur.second] + temp->weight);
				pq.push(make_pair(dist[cur.second] + temp->weight, temp->point));
			}
		}
	}

	for (int i = 1; i <= V; i++) {
		if (dist[i] == MAX_DIST)
			cout << "INF\n";
		else
			cout << dist[i] << "\n";
	}

	return 0;
}