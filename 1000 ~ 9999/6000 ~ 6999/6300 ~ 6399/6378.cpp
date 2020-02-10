#include <iostream>
#include <string>

using namespace std;

int findSum(string str);

int main() {
	string num;

	while (true) {
		cin >> num;
		
		if (num == "0")
			break;
		cout << findSum(num) << endl;
	}
}

int findSum(string str) {
	string temp = str;
	int sum;
	while (true) {
		sum = 0;
		for (int i = 0; i < temp.length(); i++) {
			sum += temp[i] - '0';
		}
		if (sum < 10)
			break;

		temp = to_string(sum);
	}
	return sum;
}