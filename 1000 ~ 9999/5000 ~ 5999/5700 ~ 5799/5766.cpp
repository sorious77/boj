#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct _info {
	int num;
	int score;
}info;

bool compare(info a, info b);

int main() {
	int n, m;

	while (true) {
		cin >> n >> m;

		if (n == 0 && m == 0)
			break;

		info player[10001];
		for (int i = 0; i <= 10000; i++) {
			player[i].num = i;
			player[i].score = 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				info temp;
				cin >> temp.num;

				player[temp.num].score++;
			}
		}

		sort(player, player + 10001, compare);

		int rank = 1;

		for (int i = 1; i < 10001; i++) {
			if (player[i].score != player[i - 1].score && rank == 1) {
				rank = 2;
				printf("%d ", player[i].num);
			}
			else if (rank == 2 && player[i].score == player[i - 1].score)
				printf("%d ", player[i].num);
			else
				break;
		}

		printf("\n");
	}
}

bool compare(info a, info b) {
	if (a.score == b.score)
		return a.num < b.num;
	else
		return a.score > b.score;
}