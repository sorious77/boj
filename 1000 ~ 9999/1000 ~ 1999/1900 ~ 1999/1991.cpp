#include <iostream>

using namespace std;

struct node {
	char data;
	char left;
	char right;
};

int N;
node tree[26];

void preorder(char c);
void inorder(char c);
void postorder(char c);

int main() {
	cin >> N;

	char data, leftChild, rightChild;

	for (int i = 0; i < N; i++) {
		cin >> data >> leftChild >> rightChild;

		tree[data - 'A'].data = data;
		tree[data - 'A'].left = leftChild;
		tree[data - 'A'].right = rightChild;
	}

	preorder('A');
	cout << "\n";
	inorder('A');
	cout << "\n";
	postorder('A');

	return 0;
}

void preorder(char c) {
	if (c == '.')
		return;

	printf("%c", c);
	preorder(tree[c - 'A'].left);
	preorder(tree[c - 'A'].right);
}

void inorder(char c) {
	if (c == '.')
		return;

	inorder(tree[c - 'A'].left);
	printf("%c", c);
	inorder(tree[c - 'A'].right);
}

void postorder(char c) {
	if (c == '.')
		return;

	postorder(tree[c - 'A'].left);
	postorder(tree[c - 'A'].right);
	printf("%c", c);
}