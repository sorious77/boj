#include <iostream>
#include <list>

using namespace std;

int min(int a, int b);

int main() {
	int n, m;
	
	list <int> qu;

	cin >> n >> m;
	int input;

	int cnt = 0;
	int head, tail;

	list <int> temp;

	for (int i = 0; i < n; i++)
		qu.push_back(i + 1);

	for (int i = 0; i < m; i++) {
		cin >> input;

		head = 0;
		tail = 0;

		if (qu.front() == input) {
			qu.pop_front();
			continue;
		}

		temp = qu; 
		while (true) {
			if (temp.front() == input)
				break;
			temp.push_back(temp.front());
			temp.pop_front();
			tail++;
		}

		temp = qu;
		while (true) {
			if (temp.front() == input)
				break;
			temp.push_front(temp.back());
			temp.pop_back();
			head++;
		}
		
		if (head > tail) {
			while (true) {
				if (qu.front() == input)
					break;
				qu.push_back(qu.front());
				qu.pop_front();
			}
		}
		else {
			while (true) {
				if (qu.front() == input)
					break;
				qu.push_front(qu.back());
				qu.pop_back();
			}
		}
		qu.pop_front();
		cnt += min(head, tail);
	}
	cout << cnt;
}

int min(int a, int b) {
	if (a > b)
		return b;
	else
		return a;
}