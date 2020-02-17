#include <iostream>
#include <vector>

using namespace std;

int dir[4][2] = { {1,0}, {0,-1}, {-1,0}, {0,1} };

int N; // 드래곤 커브의 개수
bool point[101][101] = { 0, };

void makeCurve(int x, int y, int d, int g);
int checkSquare();

int main() {
	cin >> N;

	int x, y, d, g;

	for (int i = 0; i < N; i++) {
		cin >> x >> y >> d >> g;
		makeCurve(x, y, d, g);
	}

	cout << checkSquare() << endl;
}

void makeCurve(int x, int y, int d, int g) {
	vector<int> v;

	v.push_back(d);

	point[y][x] = true;

	x += dir[d][0]; y += dir[d][1];
	point[y][x] = true;

	for (int i = 1; i <= g; i++) {
		for (int j = v.size() - 1; j >= 0; j--) {
			int nextD = (v[j] + 1) % 4;
			v.push_back(nextD);

			x += dir[nextD][0];
			y += dir[nextD][1];
			point[y][x] = true;
		}
	}
}

int checkSquare() {
	int count = 0;
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (point[j][i] && point[j + 1][i] && point[j][i + 1] && point[j + 1][i + 1])
				count++;
		}
	}

	return count;
}