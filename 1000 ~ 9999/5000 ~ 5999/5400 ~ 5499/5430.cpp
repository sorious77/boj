#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		string str, num_input;
		int size;

		cin >> str;
		cin >> size;
		cin >> num_input;

		string temp;
		vector<int> n;

		for (int i = 0; i < num_input.length(); i++) {
			if ('0' <= num_input[i] && num_input[i] <= '9') {
				temp += num_input[i];
			}
			else {
				if (temp.length() != 0) {
					n.push_back(stoi(temp));
					temp.clear();
				}
			}
		}

		bool reverse = false;
		bool check = false;

		int head = 0;
		int tail = size;

		for (int i = 0; i < str.length(); i++) {
			if (str[i] == 'R')
				reverse = !reverse;
			else {
				if (reverse) { // 거꾸로 뒤집힘
					tail--;
				}
				else {
					head++;
				}

				if (head > tail) {
					check = true;
					break;
				}
			}
		}

		if (check)
			printf("error\n");
		else {
			printf("[");
			if (reverse) { // 뒤집힌 경우
				for (int i = tail - 1; i >= head; i--) {
					printf("%d", n[i]);

					if (i != head)
						printf(",");
				}
			}
			else { // 안 뒤집힌 경우
				for (int i = head; i < tail; i++) {
					printf("%d", n[i]);

					if (i != tail - 1)
						printf(",");
				}
			}

			printf("]\n");
		}
	}
}