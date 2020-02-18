#include <iostream>
#include <vector>

using namespace std;

int number[101];
vector<char> op;
bool visit[101];
int N;

int minRes = 1000000001;
int maxRes = -1000000001;

void dfs(int op_index, int count, int num, int num_index);
int calc(int op_index, int num, int num_index);

int main() {
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> number[i];

	int op_num;

	cin >> op_num;
	for (int i = 0; i < op_num; i++)
		op.push_back('+');

	cin >> op_num;
	for (int i = 0; i < op_num; i++)
		op.push_back('-');

	cin >> op_num;
	for (int i = 0; i < op_num; i++)
		op.push_back('*');

	cin >> op_num;
	for (int i = 0; i < op_num; i++)
		op.push_back('/');

	dfs(0, 0, number[0], 0);

	printf("%d\n%d\n", maxRes, minRes);
}

void dfs(int op_index, int count, int num, int num_index) {
	if (count == N - 1) {
		if (maxRes < num)
			maxRes = num;
		if (minRes > num)
			minRes = num;

		return;
	}

	for (int i = 0; i < N - 1; i++) {
		if (!visit[i]) {
			visit[i] = true;
			int temp_num = calc(i, num, num_index);
			dfs(i, count + 1, temp_num, num_index + 1);
			visit[i] = false;
		}
	}
}

int calc(int op_index, int num, int num_index) {
	switch (op[op_index]) {
	case '+':
		return num + number[num_index + 1];
	case '-':
		return num - number[num_index + 1];
	case '*':
		return num * number[num_index + 1];
	case '/':
		return num / number[num_index + 1];
	}
}