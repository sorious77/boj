#include <iostream>
#include <string>

using namespace std;

int main()
{
	int t, r;
	char s[20];
	string S = { 0 };

	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> r >> s;

		for (int j = 0; s[j]!=NULL; j++) {
			for (int k = 0; k < r; k++) {
				cout << s[j];
				//S += s[j];
			}
			/*if (s[j] == NULL)
				break;*/
			
		}
		/*cout << S;
		S.clear();*/
		cout << endl;
	}
}