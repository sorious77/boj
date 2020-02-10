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
	int N;
	cin >> N;

	vector<dir> v;

	for (int i = 0; i < N; i++) {
		dir temp;
		cin >> temp.x >> temp.y;

		v.push_back(temp);
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < v.size(); i++) {
		printf("%d %d\n", v[i].x, v[i].y);
	}
}

bool compare(dir a, dir b) {
	if (a.y == b.y)
		return a.x < b.x;
	else
		return a.y < b.y;
}