#include <iostream>
#include <vector>

using namespace std;

int main() {
	int N;
	cin >> N;
	vector<int> v(10001);

	for (int i = 0; i < N; i++) {
		int num;
		scanf("%d", &num);
		v[num]++;
	}

	for (int i = 1; i <= 10000; i++) {
		for (int j = 0; j < v[i]; j++) {
			printf("%d\n", i);
		}
	}
}