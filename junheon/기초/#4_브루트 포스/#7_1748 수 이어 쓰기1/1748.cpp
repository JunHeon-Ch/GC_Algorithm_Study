#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int cnt = 1;
    long long ans = 0;
    int i;
    for(i = 10; i <= n; i *= 10) {
        ans += (i - i / 10) * cnt;
        cnt++;
    }
    i /= 10;
    ans += (n - i + 1) * cnt;
    cout << ans << '\n';
    return 0;
}