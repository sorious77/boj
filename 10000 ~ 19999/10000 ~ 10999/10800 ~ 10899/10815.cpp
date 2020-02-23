#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	int N, M, input;
	cin >> N;

	vector<int> card;
	vector<int> ans;

	for (int i = 0; i < N; i++) {
		cin >> input;
		card.push_back(input);
	}

	sort(card.begin(), card.end());

	cin >> M;

	for (int i = 0; i < M; i++) {
		cin >> input;

		int left = 0;
		int right = card.size() - 1;
		bool find = false;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (card[mid] == input) {
				find = true;
				break;
			}
			
			if (card[mid] > input)
				right = mid - 1;
			else
				left = mid + 1;
		}

		if (find)
			ans.push_back(1);
		else
			ans.push_back(0);
	}

	for (int i = 0; i < ans.size(); i++)
		printf("%d ", ans[i]);
}