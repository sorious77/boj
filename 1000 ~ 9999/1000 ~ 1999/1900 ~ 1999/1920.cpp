#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int m;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int input;
	vector<int> nv;
	int ans;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> input;
		nv.push_back(input);
	}

	sort(nv.begin(), nv.end());
	
	cin >> m;

	for (int i = 0; i < m; i++) {
		cin >> input;
		ans = 0;

		int start = 0;
		int end = n - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;

			if (nv.at(mid) > input) {
				end = mid - 1;
			}
			else if (nv.at(mid) < input) {
				start = mid + 1;
			}
			else {
				ans = 1;
				break;
			}
		}
		cout << ans << '\n';
	}
}