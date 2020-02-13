#include <iostream>
#include <queue>

using namespace std;

int N, K;
queue <int> q;
int visit[100001] = { 0, };

void move();

int main() {
	cin >> N >> K;
	
	q.push(N);

	move();
}

void move() {
	int ans;
	visit[N] = 1;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		if (cur == K) {
			ans = visit[cur];
			break;
		}

		if (cur - 1 >= 0 && visit[cur - 1] == 0) {
			q.push(cur - 1);
			visit[cur - 1] = visit[cur] + 1;
		}

		if (cur + 1 <= 100000 && visit[cur + 1] == 0) {
			q.push(cur + 1);
			visit[cur + 1] = visit[cur] + 1;
		}

		if (cur * 2 <= 100000 && visit[cur * 2] == 0) {
			q.push(cur * 2);
			visit[cur * 2] = visit[cur] + 1;
		}
	}

	cout << ans - 1;
}