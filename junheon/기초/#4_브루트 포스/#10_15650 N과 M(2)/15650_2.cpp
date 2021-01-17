#include <iostream>

using namespace std;
int ans[9];

void go(int index, int selected, int n, int m) {
    if(selected == m) {
        for(int i = 0; i < m; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    if(index > n) return;
    ans[selected] = index;
    go(index + 1, selected + 1, n, m);
    go(index + 1, selected, n, m);
}

int main() {
    int n, m;
    cin >> n >> m;
    go(1, 0, n, m);
    return 0;
}