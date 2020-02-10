#include <iostream>

using namespace std;

int main()
{
	int e, s, m;
	int E, S, M;
	int res = 1;

	cin >> e >> s >> m;

	E = 1;
	S = 1;
	M = 1;

	for (res = 1;; res++) {
		if (e == E && s == S && m == M)
			break;
		E++;
		S++;
		M++;

		if (E == 16)
			E = 1;
		if (S == 29)
			S = 1;
		if (M == 20)
			M = 1;
	}
	cout << res;
}