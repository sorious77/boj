#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int n; // board size
vector<pair<int, int>> v; // queen's location
int ans = 0;

void nQueen(int num);

int main() {
	cin >> n;

	nQueen(0);

	cout << ans;
}

void nQueen(int num) {
	if (num == n) {
		ans++;
		return;
	}

	vector<pair<int, int>> temp = v;
	bool check;

	for (int i = 0; i < n; i++) {
		check = true;
		for (int j = 0; j < temp.size(); j++) {
			int x = temp[j].first;
			int y = temp[j].second;

			if ((x == i) || (y == num) || (abs(x - i) == abs(y - num))) {
				check = false;
					break;
			}
		}

		if (check) {
			v.push_back(make_pair(i, num));
			nQueen(num + 1);
			v.pop_back();
		}
	}
}