#include <iostream>

using namespace std;

void fac(double *arr);

int main() {
	double arr[10];
	fac(arr);

	double arr2[10];

	cout << "n e" << endl;
	cout << "- -----------" << endl;
	
	arr2[0] = 1;
	arr2[1] = 2;
	arr2[2] = 2.5;

	cout << "0 1" << endl;
	cout << "1 2" << endl;
	cout << "2 2.5" << endl;

	for (int i = 3; i < 10; i++) {
		arr2[i] = arr2[i - 1] + (double)(1 / arr[i]);
		
		printf("%d %.9lf\n", i, arr2[i]);
	}
}

void fac(double *arr) {
	arr[0] = 1;
	arr[1] = 1;

	for (int i = 2; i < 10; i++)
		arr[i] = arr[i - 1] * i;
}