#include <iostream>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;

	map<string, bool, greater<string>> people;

	for (int i = 0; i < n; i++) {
		string name, go;

		cin >> name >> go;

		if (people.count(name)) {
			if (go == "enter")
				people[name] = true;
			else
				people[name] = false;
		}
		else {
			people.insert(make_pair(name, true));
		}
	}

	for (auto it = people.begin(); it != people.end(); it++) {
		if(it->second)
			printf("%s\n", it->first.c_str());
	}
}