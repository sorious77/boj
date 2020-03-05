#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> v;
	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		v.push_back(input);
	}

	if (prev_permutation(v.begin(), v.end())) {
		for (int i = 0; i < n; i++) {
			printf("%d ", v[i]);
		}
	}
	else
		printf("-1\n");

	return 0;
}