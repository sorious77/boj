#include <iostream>
#include <string>

#define M 1234567891
#define r 31

using namespace std;
using ll = long long;

ll mod(int num, int count);

int main() {
	int length;
	cin >> length;

	string input;
	cin >> input;

	ll hash = 0;

	for (int i = 0; i < length; i++) {
		hash = (hash + mod(input[i] - 'a' + 1, i)) % M;
	}

	cout << hash;
}

ll mod(int num, int count) {
	ll res = num;
	for (int i = 0; i < count; i++) {
		res = (res * r) % M;
	}
	
	return res;
}