#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
	int t;

	cin >> t;

	for (int i = 0; i < t; i++) {
		int num;
		cin >> num;

		vector<int> first;
		for (int j = 0; j < num; j++) {
			int input;
			cin >> input;
			first.push_back(input);
		}

		cin >> num;

		int min = 9999999;

		for (int j = 0; j < num; j++) {
			int input;
			cin >> input;

			for (int k = 0; k < first.size(); k++) {
				if (abs(input - first[k]) < min)
					min = abs(input - first[k]);
			}
		}

		printf("%d\n", min);
	}
}