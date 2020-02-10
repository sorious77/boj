#include <iostream>
#include <list>

using namespace std;

int main() {
	int n;
	int k;

	list <int> jos;

	cin >> n >> k;

	for (int i = 1; i <= n; i++)
		jos.push_back(i);

	cout << "<";

	int index = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k-1; j++) {
			int temp = jos.front();
			jos.pop_front();
			jos.push_back(temp);
		}
		if (i != n - 1)
			cout << jos.front() << ", ";
		else
			cout << jos.front() << ">";
		jos.pop_front();
	}
}