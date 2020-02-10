#include <iostream>
#include <list>

using namespace std;


int main() {
	int n;
	cin >> n;

	list<int> card;

	for (int i = 1; i <= n; i++) {
		card.push_back(i);
	}
	int size = (int)card.size();
	while (size != 1) {
		card.pop_front();

		card.push_back(card.front());
		card.pop_front();

		size--;
	}
	cout << card.front();

	
}