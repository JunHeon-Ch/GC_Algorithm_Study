#include <iostream>
#include <vector>

using namespace std;
int a[12];
int ans[6];

void go(int index, int selected, int n, int m) {
    if(index == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    if(selected >= n) return;
    ans[index] = a[selected];
    go(index + 1, selected + 1, n, m);
    go(index, selected + 1, n, m);
}

int main() {
    while(true) {
        int n;
        cin >> n;
        if(n == 0) return 0;
        for(int i = 0; i < n; i++) {
            cin >> a[i];
        }
        go(0, 0, n, 6);
        cout << '\n';
        fill_n(a, 12, 0);
    }
    return 0;
}