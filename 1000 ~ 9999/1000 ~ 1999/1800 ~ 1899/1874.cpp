#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
	int n;
	stack<int> s;
	vector<char> ans;

	cin >> n;

	int num = 1;

	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		if (s.empty() || s.top() < input) {
			for (int j = num; j <= input; j++) {
				s.push(j);
				num++;

				ans.push_back('+');
			}
		}

		if (s.top() == input) {
			s.pop();
			ans.push_back('-');
		}
		else if(s.top() > input){
			printf("NO\n");
			return 0;
		}
	}

	for (int i = 0; i < ans.size(); i++) {
		printf("%c\n", ans[i]);
	}
}