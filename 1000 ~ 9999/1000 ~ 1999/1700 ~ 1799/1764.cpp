#include <iostream>
#include <string>
#include <queue>
#include <algorithm>

using namespace std;

vector<string> listen;
vector<string> see;

int findIndex(string str, int start, int end);

int main() {
	int n, m;
	cin >> n >> m;

	string input;

	for (int i = 0; i < n; i++) {
		cin >> input;
		listen.push_back(input);
	}

	sort(listen.begin(), listen.end());

	for (int i = 0; i < m; i++) {
		cin >> input;

		if (findIndex(input, 0, listen.size()) != -1)
			see.push_back(input);
	}

	sort(see.begin(), see.end());
	printf("%d\n", see.size());

	for(int i=0;i<see.size();i++)
		cout << see[i] << endl;
}

int findIndex(string str, int start, int end) {
	int index = (start + end) / 2;
	while (start <= end) {
		index = (start + end) / 2;
		if (listen[index] == str)
			return index;

		if (listen[index] > str)
			end = index - 1;
		else
			start = index + 1;
	}

	return -1;
}