#include <iostream>

using namespace std;

typedef struct _node {
	int num;
	struct _node *left;
	struct _node *right;
}Node;

void postfix(Node *root);

int main() {
	int num;
	Node *root = NULL;

	while (cin >> num) {
		Node *temp = new Node;
		temp->num = num;
		temp->right = temp->left = NULL;

		if (root == NULL) {
			root = temp;
		}
		else {
			Node *curr = root;
			Node *prev;

			while (true) {
				if (num > curr->num) {
					prev = curr;
					if (curr->right)
						curr = curr->right;
					else {
						curr->right = temp;
						break;
					}
				}
				else {
					prev = curr;
					if (curr->left)
						curr = curr->left;
					else {
						curr->left = temp;
						break;
					}
				}
			}
		}
	}

	postfix(root);
}

void postfix(Node *root) {
	if (root) {
		postfix(root->left);
		postfix(root->right);
		printf("%d ", root->num);
	}
}