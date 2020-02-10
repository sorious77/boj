#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	int n;
	vector<int> v;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		int num;
		scanf("%d", &num);

		v.push_back(num);
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		printf("%d\n", v[i]);
	}
}