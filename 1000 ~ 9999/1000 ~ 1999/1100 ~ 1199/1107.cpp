#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <string>

using namespace std;

bool button[10];
int N, M;

void dfs(string num);

int ans = 9999999;

int main() {
	cin >> N >> M;

	memset(button, true, sizeof(button));

	for (int i = 0; i < M; i++) {
		int input;
		cin >> input;
		button[input] = false;
	}

	dfs("");

	ans = min(ans, abs(100 - N));

	cout << ans;

	return 0;
}

void dfs(string num) {
	if (num.length() >= 7)
		return;

	for (int i = 0; i < 10; i++) {
		if (button[i]) {
			num += i + '0';
			int size = num.length();
			ans = min(ans, abs(N - stoi(num)) + size);
			dfs(num);
			num.erase(num.end() - 1);
		}
	}
}