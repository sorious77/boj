#include <iostream>

using namespace std;
using ll = long long;

int main() {
	ll n;
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	ll front = 1, end = 1;
	ll level = 1;

	while (end < n) {
		front = end + 1;
		end = front + level;
		level++;
	}

	ll index;

	// level이 홀수라면, level/1부터 시작
	if (level % 2 == 1) {
		index = end - n + 1;
	}

	// level이 짝수라면, 1/level부터 시작
	else {
		index = n - front + 1;
	}

	cout << index << "/" << level - index + 1 << endl;
}