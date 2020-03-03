#include <iostream>
#include <string>
#include <map>

using namespace std;

map<string, string> pw;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(0);

	int n, m;
	cin >> n >> m;

	string addr, pass;
	for (int i = 0; i < n; i++) {
		cin >> addr >> pass;
		pw.insert(make_pair(addr, pass));
	}

	for (int i = 0; i < m; i++) {
		cin >> addr;
		cout << pw[addr] << "\n";
	}

	return 0;
}