#include <iostream>
#include <string>

using namespace std;
int N, M;

int main() {
	cin >> N >> M;

	string input;
	int count = 0;
	int res = 0;

	cin >> input;
	
	for (int i = 1; i < input.length() - 1; i++) {
		if (input[i - 1] == 'I' && input[i] == 'O' && input[i + 1] == 'I') {
			while (input[i-1] == 'I' && input[i] == 'O' && input[i + 1] == 'I') {
				count++;
				if (count == N) {
					count--;
					res++;
				}
				i += 2;
			}
		}
		count = 0;
	}

	cout << res;

	return 0;
}