#include <iostream>
#include <sstream>

using namespace std;

bool checkSSS(int);

int main()
{
	int n, cnt = 0, i;

	cin >> n;
	for (i = 666; ; i++) {
		if (checkSSS(i))
			cnt++;
		if (cnt == n)
			break;
	}
	cout << i << endl;
}

bool checkSSS(int num) {
	string s = { 0 };
	ostringstream o;
	if (num < 666)
		return false;
	o << num;
	s = o.str();

	if (s.find("666")==-1)
		return false;
	else
		return true;
}