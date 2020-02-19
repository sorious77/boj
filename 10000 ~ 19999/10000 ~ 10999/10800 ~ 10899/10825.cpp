#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

typedef struct _student{
	string name;
	int kor;
	int eng;
	int math;
}student;

bool compare(student a, student b);

int main() {
	int N;
	vector<student> s;

	cin >> N;

	for (int i = 0; i < N; i++) {
		student temp;
		cin >> temp.name >> temp.kor >> temp.eng >> temp.math;

		s.push_back(temp);
	}

	sort(s.begin(), s.end(), compare);

	for (int i = 0; i < s.size(); i++) {
		printf("%s\n", s[i].name.c_str());
	}
}

bool compare(student a, student b) {
	if (a.kor == b.kor) {
		if (a.eng == b.eng) {
			if (a.math == b.math) {
				return a.name < b.name;
			}
			else
				return a.math > b.math;
		}
		else
			return a.eng < b.eng;
	}
	else
		return a.kor > b.kor;
}