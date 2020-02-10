#include <iostream>

using namespace std;

int main() {
	int input, cnt = 0;

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> input;
			if (input == 0)
				cnt++;
		}
		if (cnt == 0)
			printf("E\n");
		else
			printf("%c\n", cnt + 'A' - 1);

		cnt = 0;
	}
}