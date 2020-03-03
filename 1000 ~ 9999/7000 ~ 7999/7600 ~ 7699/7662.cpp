#include <iostream>
#include <set>

using namespace std;

int main() {
	int test_case;

	cin >> test_case;

	for (int t = 0; t < test_case; t++) {
		int N;
		cin >> N;

		multiset<int> s;

		for (int i = 0; i < N; i++) {
			char op;
			int num;
			cin >> op >> num;

			if (op == 'I') {
				s.insert(num);
			}
			else {
				if (!s.empty()) {
					if (num == 1) {
						auto it = s.end();
						it--;
						s.erase(it);
					}
					else
						s.erase(s.begin());
				}
			}
		}

		if (s.empty())
			cout << "EMPTY" << "\n";
		else {
			auto it = s.end();
			it--;
			cout << *it << " " << *s.begin() << "\n";
		}
	}
	
}