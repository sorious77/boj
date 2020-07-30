#include <iostream>
#include <string>

using namespace std;

int N;

int main() {
	string target;
	string str;
	int len, count = 0;

	cin >> target;
	cin >> N;
	
	len = target.length();
	bool check;

	for (int i = 0; i < N; i++) {
		cin >> str;

		check = false;

		string temp;
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < len; k++) {
				if (j + k >= 10) {
					temp += str[j + k - 10];
				}
				else {
					temp += str[j + k];
				}
			}
			if (temp == target) {
				check = true;
				break;
			}
			temp.clear();
		}
		if(check){
			count++;
		}
	}

	cout << count;

	return 0;
}