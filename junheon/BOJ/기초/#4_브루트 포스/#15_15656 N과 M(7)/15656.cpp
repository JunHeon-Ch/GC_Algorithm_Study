#include <iostream>
#include <algorithm>

using namespace std;
int a[7];
int ans[7];

void go(int index, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = 0; i < n; i++) {
        ans[index] = a[i];
        go(index + 1, n, m);
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    go(0, n, m);
    return 0;
}