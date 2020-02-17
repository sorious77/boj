#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	int num;
	string str;
	while (true) {
		cin >> num;

		if (num == 0)
			break;

		vector<char> *v = new vector<char>[num];

		cin >> str;

		int line = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (i != 0 && i%num == 0)
				line++;
			if(line % 2 == 0)
				v[i % num].push_back(str[i]);
			else {
				v[num - (i % num) - 1].push_back(str[i]);
			}
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < v[i].size(); j++) {
				printf("%c", v[i][j]);
			}
		}
		printf("\n");
	}
}