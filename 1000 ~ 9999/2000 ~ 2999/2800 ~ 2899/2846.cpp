#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;

	int *arr = new int[n + 1];

	arr[0] = 0;

	for (int i = 1; i <= n; i++)
		cin >> arr[i];

	int max = 0;
	int start = 1, end;

	for (int i = 1; i <= n; i++) {
		if (arr[i] > arr[i - 1])
			end = i;
		else {
			if (start > end)
				continue;
			if (max < arr[end]-arr[start] && start!=end) {
				max = arr[end]-arr[start];
			}
			start = i;
			end = i;
		}
	}
	if (max < arr[end] - arr[start] && start != end)
		max = arr[end] - arr[start];
 	cout << max;
}