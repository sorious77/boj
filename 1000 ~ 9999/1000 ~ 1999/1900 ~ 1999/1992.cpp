#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct pos {
	int x, y;
};

void solve(pos start, pos end, int size);

int N;
int arr[65][65];
vector<char> print;

int main() {
	cin >> N;

	string input;
	for (int i = 1; i <= N; i++) {
		cin >> input;
		for (int j = 1; j <= N; j++) {
			arr[i][j] = input[j - 1] - '0';
		}
	}
	pos start = { 1,1 };
	pos end = { N,N };

	solve(start, end, N);

	for (int i = 0; i < print.size(); i++)
		printf("%c", print[i]);

	return 0;
}

void solve(pos start, pos end, int size) {
	int ch = arr[start.y][start.x];

	if (size == 1) {
		print.push_back(ch + '0');
		return;
	}

	for (int i = start.y; i <= end.y; i++) {
		for (int j = start.x; j <= end.x; j++) {
			if (ch != arr[i][j]) {
				pos nextS, nextE;
				size /= 2;

				print.push_back('(');

				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						nextS.x = start.x + size * l;	nextS.y = start.y + size * k;
						nextE.x = start.x + size * (l + 1) - 1;	nextE.y = start.y + size * (k + 1) - 1;
						solve(nextS, nextE, size);
					}
				}
				print.push_back(')');
				return;
			}
		}
	}

	print.push_back(ch + '0');
}