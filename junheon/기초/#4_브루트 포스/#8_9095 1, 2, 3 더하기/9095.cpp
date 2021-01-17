#include <iostream>

using namespace std;
int ans;

void go(int now, int n) {
    if(n < now) {
        return;
    }
    if(n == now) {
        ans++;
        return;
    }
    go(now + 3, n);
    go(now + 2, n);
    go(now + 1, n);
}

int main() {
    int t;
    cin >> t;
    while(t--) {
        ans = 0;
        int n;
        cin >> n;
        go(0, n);
        cout << ans << '\n';
    }
    return 0;
}