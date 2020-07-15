#include <iostream>
#include <string>

using namespace std;

int main() {
	string shark[] = { "baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu", "in", "bed", "tururu", "turu", "baby", "sukhwan" };

	int n, repeat;

	cin >> n;

	repeat = n / 14;
	
	n = (n - 1) % 14;

	if (shark[n] == "tururu"){
		if (repeat >= 3) {
			printf("tu+ru*%d", repeat + 2);
		}
		else {
			printf("tururu");

			for (int i = 0; i < repeat; i++) {
				printf("ru");
			}
		}
	}
	else if (shark[n] == "turu") {
		if (repeat >= 4) {
			printf("tu+ru*%d", repeat + 1);
		}
		else {
			printf("turu");

			for (int i = 0; i < repeat; i++) {
				printf("ru");
			}
		}
	}
	else {
		cout << shark[n];
	}

	return 0;
}