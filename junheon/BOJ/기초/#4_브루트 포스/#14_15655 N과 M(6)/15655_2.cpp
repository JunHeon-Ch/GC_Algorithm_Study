#include <iostream>
#include <algorithm>

using namespace std;
int a[8];
int ans[8];

void go(int index, int selected, int n, int m) {
    if(selected == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    if(index >= n) return;
    ans[selected] = a[index];
    go(index + 1, selected + 1, n, m);
    go(index + 1, selected, n, m);
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