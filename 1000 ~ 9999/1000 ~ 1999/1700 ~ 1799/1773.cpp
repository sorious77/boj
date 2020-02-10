#include <iostream>

using namespace std;

int main() {
	int n, c;
	cin >> n >> c;

	int *cycle = new int[n];
	bool *time = new bool[c + 1];

	for (int i = 0; i < n; i++)
		cin >> cycle[i];

	for (int i = 0; i <= c; i++) {
		time[i] = false;
	}

	for (int i = 1; i <= c; i++) {
		for (int j = 0; j < n; j++) {
			if (i%cycle[j] == 0)
				time[i] = true;
		}
	}
	int cnt = 0;
	for (int i = 1; i <= c; i++) {
		if (time[i])
			cnt++;
	}
	cout << cnt;
}