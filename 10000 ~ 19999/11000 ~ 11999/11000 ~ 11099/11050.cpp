#include <iostream>

using namespace std;

int arr[11];
void fibo(int n);

int main() {
	int n, k;
	cin >> n >> k;
	
	arr[0] = 1;
	arr[1] = 1;

	fibo(n);

	cout << arr[n]/(arr[k]*arr[n-k]);
}

void fibo(int n) {
	for (int i = 2; i <= n; i++) {
		arr[i] = arr[i - 1] * i;
	}
}