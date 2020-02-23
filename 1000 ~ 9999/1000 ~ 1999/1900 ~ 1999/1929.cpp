#include <iostream>

using namespace std;

int N, M;

bool num[1000001];

int nextSosu(int cur);

int main() {
	cin >> N >> M;

	int cur = 1;

	num[1] = true;

	while (true) {
		cur = nextSosu(cur);

		if (cur == -1)
			break;

		for (int i = 2;; i++) {
			if (i * cur > M)
				break;

			num[i * cur] = true;
		}
	}

	for (int i = N; i <= M; i++) {
		if (!num[i])
			printf("%d\n", i);
	}
}

int nextSosu(int cur) {
	for (int i = cur + 1; i <= M; i++) {
		if (!num[i])
			return i;
	}

	return -1;
}