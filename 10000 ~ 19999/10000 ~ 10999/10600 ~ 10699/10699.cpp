#include <iostream>
#include <time.h>

using namespace std;

int main() {
	struct tm* now;
	time_t now_t;

	time(&now_t);

	now = localtime(&now_t);

	printf("%d-%02d-%02d\n", now->tm_year + 1900, now->tm_mon + 1, now->tm_mday);
}