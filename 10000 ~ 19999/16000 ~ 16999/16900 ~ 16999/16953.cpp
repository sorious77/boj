#include <iostream>
#include <queue>

using namespace std;

#define MAXNUM 1000000000

int main() {
	int A, B;
	bool finish = false;

	cin >> A >> B;

	queue<pair<int, int>> q;
	q.push(make_pair(A, 1));

	while(!q.empty()){
		int num = q.front().first;
		int count = q.front().second;
		q.pop();

		if(num == B){
			cout << count;
			finish = true;
			break;
		}

		if(num * 2 <= B){
			q.push(make_pair(num * 2, count + 1));
		}
		if (num <= MAXNUM / 10) {
			if (num * 10 + 1 <= B) {
				q.push(make_pair(num * 10 + 1, count + 1));
			}
		}
	}

	if(!finish){
		cout << -1;
	}

	return 0;
}