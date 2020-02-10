#include <iostream>

using namespace std;

bool check(int n, int *p);
int jos(int n, int k, int *p, int res);

int main() {
	int n, k;

	cin >> n >> k;

	int *p = new int[n + 1];
	for (int i = 0; i <= n; i++)
		p[i] = 1;

	int temp, cnt = 1;

	int *res = new int[n + 1];

	cout << "<";

	temp = 1;

	while (check(n, p)) {
		temp = jos(n, k, p, temp);
		res[cnt] = temp;
		cnt++;
	}

	for (int i = 1; i < cnt-1; i++) {
		printf("%d, ", res[i]);
	}

	printf("%d>", res[cnt-1]);
}

bool check(int n, int *p) {
	for (int i = 1; i <= n; i++)
		if (p[i])
			return true;
	return false;
}

int jos(int n, int k, int *p, int res) {
	int cnt = 0;
	for (int i=res;;i++) {
		if (p[i])
			cnt++;
		
		if (cnt == k) {
			p[i] = 0;
			return i;
		}
		
		if (i >= n)
			i = 0;
	}
}