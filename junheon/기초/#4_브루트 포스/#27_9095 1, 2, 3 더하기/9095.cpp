#include <iostream>

using namespace std;
int ans;

int go(int n) {
    if(n < 0) {
        return 0;
    }
    if(n == 0) {
        return 1;
    }
    int ans = 0;
    ans += go(n - 3);
    ans += go(n - 2);
    ans += go(n - 1);
    return ans;
}

int main() {
    int t;
    cin >> t;
    while(t--) {
        ans = 0;
        int n;
        cin >> n;
        int ans = go(n);
        cout << ans << '\n';
    }
    return 0;
}