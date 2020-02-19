#include <iostream>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

int main() {
	int test_case;

	cin >> test_case;

	for (int i = 0; i < test_case; i++) {
		int n;
		cin >> n;

		map<string, int> clothes;
		string name, type;
		
		for (int j = 0; j < n; j++) {
			cin >> name >> type;

			if (clothes.count(type)) {
				clothes[type]++;
			}
			else {
				clothes.insert(make_pair(type, 1));
			}
		}
		int count = 1;
		
		for (auto it = clothes.begin(); it != clothes.end(); ++it) {
			count *= it->second + 1;
		}

		cout << count - 1 << endl;
	}
}