#include <iostream>

using namespace std;
int a[15][15];
int n;
int ans = 0;

void queen(int x, int y, int flag) {
    for(int i = x + 1; i < n; i++)
        a[i][y] += flag;
    for(int i = x + 1, j = y + 1; i < n && j < n; i++, j++)
        a[i][j] += flag;
    for(int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--)
        a[i][j] += flag;
}

void go(int cnt) {
    if(cnt == n) {
        ans++;
        return;
    }
    for(int j = 0; j < n; j++) {
        if(!a[cnt][j]) {
            queen(cnt, j, 1);
            go(cnt + 1);
            queen(cnt, j, -1);
        }
    }
}

int main() {
    cin >> n;

    go(0);

    cout << ans << '\n';
    return 0;
}