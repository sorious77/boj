#include <iostream>
#include <queue>

using namespace std;

struct Data {
	int order;
	int pro;
};

int main() {
	int n;
	cin >> n;

	queue<Data> data, temp;
	int num, idx, cur, popIdx;
	bool check;

	for (int i = 0; i < n; i++) {
		Data input;
		cin >> num >> idx;
		for (int j = 0; j < num; j++) {
			input.order = j;
			cin >> input.pro;
			data.push(input);
		}

		popIdx = 0;

		int cnt;

		for (int j = 0;; j++) {
			temp = data;
			cur = temp.front().pro;
			cnt = 0;
			check = false;
			while (true) { 
				if (temp.front().pro > cur) { // 제일 앞 중요도와 비교
					check = true; // 더 큰 중요도 존재
					break;
				}
				if (cnt >= temp.size()) // 전체 비교 완료
					break;
				temp.push(temp. front()); // 다음껄로 넘어감
				temp.pop(); // 다음껄로 넘어감
				cnt++;
			}
			if (check) { // 더 큰 중요도 존재
				data.push(data.front()); // 제일 뒤로 push
				data.pop(); // 제일 뒤로 push
			}
			else { // 더 큰 중요도 존재 X
				popIdx++;
				if (data.front().order == idx) { // 원하는 index 값과 같을 때
					cout << popIdx << endl; // 출력
					break; // case 종료
				}
				data.pop(); // 원하는 index 값이 아닐때 pop만
			}
		}
		while(!data.empty())	data.pop();
	}
}