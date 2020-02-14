#include <iostream>
#include <vector>

using namespace std;

int ranking[51];
vector<pair<int, int>> person;

int main() {
	int n;
	cin >> n;

	int w, h;
	for (int i = 0; i < n; i++) {
		cin >> w >> h;

		person.push_back(make_pair(w, h));
		ranking[i] = 1;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j)
				continue;

			if (person[i].first < person[j].first && person[i].second < person[j].second)
				ranking[i]++;
		}
	}

	for (int i = 0; i < n; i++) {
		printf("%d ", ranking[i]);
	}
}