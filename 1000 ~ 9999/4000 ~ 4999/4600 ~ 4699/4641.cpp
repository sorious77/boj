#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int main() {
	int input;
	int num[16];
	
	while (true) {
		memset(num, 0, sizeof(num));
		int idx = 0;
		while (true) {
			cin >> input;
			if (input == 0)
				break;

			if (input == -1)
				return 0;

			num[idx++] = input;
		}
		sort(num, num + idx);
		int cnt = 0;
		for (int i = 0; i < idx; i++) {
			for (int j = i + 1; j < idx; j++) {
				if (num[i] * 2 == num[j])
					cnt++;
			}
		}
		cout << cnt << endl;
	}
}