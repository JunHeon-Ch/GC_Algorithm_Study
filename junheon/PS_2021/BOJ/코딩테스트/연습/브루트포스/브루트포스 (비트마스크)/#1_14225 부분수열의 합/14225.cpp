// bitmask
// timeover
#include <iostream>

using namespace std;
int a[20];
int n;
int res = 0;

void go(int selected, int sum) {
    // escape condition
    if(selected == n) {
        res = res | (1 << sum);
        return;
    }
    // select
    go(selected + 1, sum + a[selected]);
    // not select
    go(selected + 1, sum);
}

int main() {
    // input
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    go(0, 0);
    int ans = 0;
    while(res & (1 << ans)) ans++;

    // output
    cout << ans << '\n';
    return 0;
}