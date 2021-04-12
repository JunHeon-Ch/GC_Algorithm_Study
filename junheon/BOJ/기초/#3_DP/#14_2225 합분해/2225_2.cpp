#include <iostream>

using namespace std;
const long long DIV = 1000000000LL;
long long d[201][201];

int main() {
    int n, k;
    cin >> n >> k;
    for(int i = 0; i <= k; i++) {
        d[i][0] = 1LL;
    }
    for(int i = 1; i <= k; i++) {
        for(int j = 1; j <= n; j++) {
            d[i][j] = (d[i][j - 1] + d[i - 1][j]) % DIV;
        }
    }
    cout << d[k][n] << '\n';

    return 0;
}