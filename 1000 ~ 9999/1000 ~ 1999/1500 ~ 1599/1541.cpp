#include <iostream>
#include <string>

using namespace std;

int main() {
	int sum = 0;

	string input;
	cin >> input;

	bool minus = false;
	string temp;

	for (int i = 0; i < input.length(); i++) {
		if ('0' <= input[i] && input[i] <= '9')
			temp += input[i];
		else {
			if (minus) {
				sum -= stoi(temp);
				temp.clear();
			}
			else {
				sum += stoi(temp);
				temp.clear();
			}

			if (input[i] == '-')
				minus = true;
		}
	}

	if (minus) {
		sum -= stoi(temp);
	}
	else {
		sum += stoi(temp);
	}

	cout << sum;
}