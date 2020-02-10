#include <iostream>

using namespace std;

#define SWAP(a,b) {char temp = a; a = b; b=temp;}

int main() {
	char a[4], b[4];

	cin >> a >> b;

	SWAP(a[0], a[2]);
	SWAP(b[0], b[2]);

	if (atoi(a) > atoi(b))
		cout << a;
	else
		cout << b;
}
