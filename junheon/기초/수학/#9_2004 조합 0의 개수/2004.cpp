#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int cnt5 = 0, cnt2 = 0;
    for(long long i = 5; i <= n; i *= 5) {
        cnt5 += n / i;
    }
    for(long long i = 5; i <= m; i *= 5) {
        cnt5 -= m / i;
    }
    for(long long i = 5; i <= n - m; i *= 5) {
        cnt5 -= (n - m) / i;
    }
    for(long long i = 5; i <= n; i *= 5) {
        cnt2 += n / i;
    }
    for(long long i = 5; i <= m; i *= 5) {
        cnt2 -= m / i;
    }
    for(long long i = 5; i <= n - m; i *= 5) {
        cnt2 -= (n - m) / i;
    }

    cout << min(cnt2, cnt5) << '\n';

    return 0;
}