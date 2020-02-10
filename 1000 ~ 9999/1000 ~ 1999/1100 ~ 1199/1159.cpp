#include <iostream>

using namespace std;

int main() {
	int arr[26] = { 0, };
	int n;
	char name[31];

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> name;

		arr[name[0] - 'a']++;
	}

	bool check = false;

	for (int i = 0; i < 26; i++) {
		if (arr[i] >= 5) {
			printf("%c", i+'a');
			check = true;
		}
	}
	if (!check)
		cout << "PREDAJA";
}