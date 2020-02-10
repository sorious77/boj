#include <iostream>

using namespace std;

int main() {
	char a[4], b[4];
	int first, second;

	cin >> a >> b;

	first = atoi(a);
	second = atoi(b);
	
	cout << first * (b[2] - '0') << endl;
	cout << first * (b[1] - '0') << endl;
	cout << first * (b[0] - '0') << endl;
	cout << first * second << endl;
}