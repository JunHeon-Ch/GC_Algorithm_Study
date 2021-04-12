#include <iostream>

using namespace std;
struct Node {
    int left;
    int right;
};
Node t[30];
int n;

void preorder(int root) {
    if(root == 0)
        return;
    cout << char(root + 64);
    preorder(t[root].left);
    preorder(t[root].right);
}

void inorder(int root) {
    if(root == 0)
        return;
    inorder(t[root].left);
    cout << char(root + 64);
    inorder(t[root].right);
}

void postorder(int root) {
    if(root == 0)
        return;
    postorder(t[root].left);
    postorder(t[root].right);
    cout << char(root + 64);
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for(int i = 0; i < n; i++) {
        char a, b, c;
        cin >> a >> b >> c;
        int index = a - 64;
        if(b != '.') {
            t[index].left = b - 64;
        }
        if(c != '.') {
            t[index].right = c - 64;
        }
    }
    preorder(1);
    cout << '\n';
    inorder(1);
    cout << '\n';
    postorder(1);
    cout << '\n';

    return 0;
}