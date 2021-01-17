#include <iostream>
#include <algorithm>

using namespace std;
bool check[8];
int ans[8];
int a[8];

void go(int index, int n, int m) {
    if(index == m) {
        for(int i = 0; i < index; i++) {
            cout << ans[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = 0; i < n; i++) {
        if(check[i]) {
            continue;
        }
        check[i] = true;
        ans[index] = a[i];
        go(index + 1, n, m);
        check[i] = false;
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