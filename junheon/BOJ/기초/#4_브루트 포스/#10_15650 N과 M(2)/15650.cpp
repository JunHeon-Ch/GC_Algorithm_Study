#include <iostream>

using namespace std;
bool check[9];
int ans[8];

void go(int index, int n, int m, int p) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = p + 1; i <= n; i++) {
        if(check[i]) {
            continue;
        }
        check[i] = true;
        ans[index] = i;
        go(index + 1, n, m, i);
        check[i] = false;
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    go(0, n, m, 0);
    return 0;
}