#include <iostream>

using namespace std;
const long long DIV = 1000000000LL;
long long d[201][201];

int main() {
    int n, k;
    cin >> n >> k;
    d[0][0] = 1LL;
    for(int i = 1; i <= k; i++) {
        for(int j = 0; j <= n; j++) {
            for(int m = 0; m <= j; m++) {
                d[i][j] = (d[i][j] + d[i - 1][j - m]) % DIV;
            }
        }
    }
    cout << d[k][n] << '\n';

    return 0;
}