#include <iostream>
#include <algorithm>

using namespace std;
int a[8];
int ans[8];

void go(int index, int start, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = start; i < n; i++) {
        ans[index] = a[i];
        go(index + 1, i, n, m);
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    go(0, 0, n, m);
    return 0;
}