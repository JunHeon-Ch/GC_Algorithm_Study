#include <iostream>
#include <cstring>

using namespace std;
struct Node {
    int left;
    int right;
};
// t -> Ʈ�� / g -> ���� ���� �� ���� ���ʿ� �ִ� ����� �� ����
// w -> ���� �� �ʺ� / r -> ��Ʈ ������� �ƴ��� ã�� ����
Node t[10000];
int g[10000];
int w[10000];
bool r[10000];
int col = 0;

// row -> ����
void inorder(int root, int row) {
    if(root == -2) return;
    inorder(t[root].left, row + 1);
    if(g[row] == -1) g[row] = col;
    w[row] = col - g[row] + 1;
    col++;
    inorder(t[root].right, row + 1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // �Է�
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        a--; b--; c--;
        t[a].left = b;
        t[a].right = c;
        if(b != -2) r[b] = true;
        if(c != -2) r[c] = true;
    }
    // ��Ʈ ã��
    int root = 0;
    for(int i = 0; i < n; i++) {
        if(!r[i]) root = i;
    }
    memset(g, -1, sizeof(g));

    inorder(root, 0);
    // �ʺ� ���� ���� ���� ã��
    int ansIndex = 0;
    int i = 1;
    while(w[i] != 0) {
        if(w[ansIndex] < w[i]) {
            ansIndex = i;
        }
        i++;
    }
    cout << ansIndex + 1 << ' ' << w[ansIndex] << '\n';
    return 0;
}