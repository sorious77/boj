#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

typedef struct person {
	int age;
	int index;
	string name;
}person;

bool compare(person a, person b);

int main() {
	int n;
	cin >> n;

	vector<person> v;

	for (int i = 0; i < n; i++) {
		person temp;
		cin >> temp.age >> temp.name;

		temp.index = i;

		v.push_back(temp);
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < n; i++) {
		printf("%d %s\n", v[i].age, v[i].name.c_str());
	}
}

bool compare(person a, person b) {
	if (a.age == b.age)
		return a.index < b.index;
	else
		return a.age < b.age;
}