#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n, num;
	scanf("%d", &n);

	vector<int> v;

	for (int i = 0; i < n; i++) {
		scanf("%d", &num);

		v.push_back(num);
	}

	sort(v.begin(), v.end());

	int m;
	scanf("%d", &m);

	vector<int>::iterator iter;

	for (int i = 0; i < m; i++) {
		scanf("%d", &num);

		printf("%d ", upper_bound(v.begin(), v.end(), num) - lower_bound(v.begin(), v.end(), num));
	}
}