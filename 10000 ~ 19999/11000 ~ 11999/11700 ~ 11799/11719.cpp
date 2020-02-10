#include <iostream>
#include <string>

using namespace std;

int main()
{
	char str[101];
	for (int i = 0; i < 100; i++) {
		cin.getline(str, sizeof(str));
		cout << str << endl;
	}
}