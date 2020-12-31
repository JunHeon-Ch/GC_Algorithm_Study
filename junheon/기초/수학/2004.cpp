#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int cnt5 = 0, cnt2 = 0;
    for(long long i = 5; i <= n; i *= 5) {
        cnt5 += n / i;
        cnt5 -= m / i;
        cnt5 -= (n - m) / i;
    }
    for(long long i = 2; i <= n; i *= 2) {
        cnt2 += n / i;
        cnt2 -= m / i;
        cnt2 -= (n - m) / i;
    }
    cout << min(cnt2, cnt5) << '\n';


    return 0;
}