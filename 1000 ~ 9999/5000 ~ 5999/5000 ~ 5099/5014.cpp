#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int F, S, G, U, D;

void bfs();

int main() {
	cin >> F >> S >> G >> U >> D;

	bfs();

	return 0;
}

void bfs() {
	queue<int> q;
	vector<int> visit(F + 1);

	q.push(S);
	visit[S] = 1;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		if (cur == G) {
			cout << visit[cur] - 1 << "\n";
			return;
		}

		if (cur + U <= F && visit[cur + U] == 0) {
			q.push(cur + U);
			visit[cur + U] = visit[cur] + 1;
		}

		if (cur - D >= 1 && visit[cur - D] == 0) {
			q.push(cur - D);
			visit[cur - D] = visit[cur] + 1;
		}
	}

	cout << "use the stairs\n" << "\n";
	return;
}