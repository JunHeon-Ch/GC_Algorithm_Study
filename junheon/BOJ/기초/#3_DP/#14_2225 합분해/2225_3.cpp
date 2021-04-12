#include <iostream>

using namespace std;
const long long DIV = 1000000000LL;
long long d[201];

int main() {
    int n, k;
    cin >> n >> k;
    d[0] = 1LL;
    for(int i = 1; i <= k; i++) {
        for(int j = 1; j <= n; j++) {
            d[j] = (d[j] + d[j - 1]) % DIV;
        }
    }
    cout << d[n] << '\n';

    return 0;
}