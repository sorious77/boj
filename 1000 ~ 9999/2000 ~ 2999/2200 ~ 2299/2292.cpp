#include <iostream>

using namespace std;

int main() {
	int n;

	cin >> n;

	int front = 1, back = 1;
	int temp = 6;
	int count = 1;

	while (n > back) {
		front = back + 1;
		back += temp;
		temp += 6;
		count++;
	}

	cout << count;
}