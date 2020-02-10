#include <iostream>

using namespace std;

int main() {
	int n, temp, cnt = 0;
	cin >> n;

	temp = n;

	do{
		temp = temp % 10 * 10+ (temp % 10 + temp / 10) % 10;
		cnt++;
	} while (n != temp);

	cout << cnt << endl;
}