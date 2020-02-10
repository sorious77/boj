#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, k;
	cin >> n >> k;

	int *arr = new int[n];

	for (int i = 0; i < n; i++)
		scanf("%d",&arr[i]);

	sort(arr, arr + n);
	
	printf("%d\n", arr[k - 1]);
    delete[]arr;
}
