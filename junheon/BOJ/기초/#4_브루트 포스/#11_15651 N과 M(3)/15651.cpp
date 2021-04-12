#include <iostream>

using namespace std;
int ans[7];

void go(int index, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = 1; i <= n; i++) {
        ans[index] = i;
        go(index + 1, n, m);
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    go(0, n, m);
    return 0;
}