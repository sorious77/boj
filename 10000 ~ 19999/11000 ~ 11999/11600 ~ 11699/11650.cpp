#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct dir {
	int x;
	int y;
}dir;

bool compare(dir a, dir b);

int main() {
	int n;
	cin >> n;

	vector<dir> v;

	for (int i = 0; i < n; i++) {
		dir temp;
		cin >> temp.x >> temp.y;

		v.push_back(temp);
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < n; i++) {
		printf("%d %d\n", v[i].x, v[i].y);
	}
}

bool compare(dir a, dir b) {
	if (a.x == b.x)
		return a.y < b.y;
	else
		return a.x < b.x;
}