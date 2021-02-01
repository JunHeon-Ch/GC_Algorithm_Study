#include <iostream>
#include <cstring>

using namespace std;
struct Node {
    int left;
    int right;
};
// t -> 트리 / g -> 같은 레벨 중 제일 왼쪽에 있는 노드의 열 저장
// w -> 레벨 별 너비 / r -> 루트 노드인지 아닌지 찾기 위함
Node t[10000];
int g[10000];
int w[10000];
bool r[10000];
int col = 0;

// row -> 레벨
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

    // 입력
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
    // 루트 찾기
    int root = 0;
    for(int i = 0; i < n; i++) {
        if(!r[i]) root = i;
    }
    memset(g, -1, sizeof(g));

    inorder(root, 0);
    // 너비가 가장 넓은 레벨 찾기
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