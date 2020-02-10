#include <iostream>

using namespace std;

int main() {
	char str1[6][16] = { "SHIP NAME", "N2 Bomber", "J-Type 327", "NX Cruiser", "N1 Starfighter", "Royal Cruiser" };
	char str2[6][16] = { "CLASS", "Heavy Fighter", "Light Combat", "Medium Fighter", "Medium Fighter", "Light Combat" };
	char str3[6][12] = { "DEPLOYMENT", "Limited", "Unlimited", "Limited", "Unlimited", "Limited" };
	char str4[6][11] = { "IN SERVICE", "21", "1", "18", "25", "4" };

	for (int i = 0; i < 6; i++) {
		printf("%-15s%-15s%-11s%-10s\n", str1[i], str2[i], str3[i], str4[i]);
	}
	
}