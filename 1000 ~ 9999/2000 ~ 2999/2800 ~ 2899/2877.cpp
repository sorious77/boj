#include <iostream>
#include <vector>

using namespace std;

vector<int> v;

void to_binary(int num);

int main() {
	int num;
	cin >> num;

	to_binary(num + 1);

	for (int i = 1; i < v.size(); i++) {
		if (v[i] == 0)
			printf("4");
		else
			printf("7");
	}
}

void to_binary(int num) {
	vector<int> temp;

	while (num >= 1) {
		temp.push_back(num % 2);
		num /= 2;
	}

	for (int i = temp.size()-1; i >= 0; i--) {
		v.push_back(temp[i]);
	}
}