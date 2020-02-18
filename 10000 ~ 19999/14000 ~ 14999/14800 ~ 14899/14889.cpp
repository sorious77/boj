#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void dfs(int num, int size);

int arr[20][20];
bool visit[20];

int N;
int res = 999999;

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	dfs(0, 0);

	cout << res;
}

void dfs(int num, int size) {
	visit[num] = true;
	size++;

	if (size == N / 2) {
		vector<int> start;
		vector<int> link;

		for (int i = 0; i < N; i++) {
			if (visit[i])
				start.push_back(i);
			else
				link.push_back(i);
		}

		int sSum = 0;
		int lSum = 0;

		for (int i = 0; i < start.size(); i++) {
			for (int j = 0; j < start.size(); j++) {
				sSum = sSum + arr[start[i]][start[j]];
				lSum = lSum + arr[link[i]][link[j]];
			}
		}
		if (abs(sSum - lSum) < res)
			res = abs(sSum - lSum);

		return;
	}

	for (int i = num + 1; i < N; i++) {
		if (!visit[i]) {
			dfs(i, size);
			visit[i] = false;
		}
	}
}