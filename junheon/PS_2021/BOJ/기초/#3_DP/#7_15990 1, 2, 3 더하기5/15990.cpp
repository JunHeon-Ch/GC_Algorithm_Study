#include <iostream>

using namespace std;
const long long DIV = 1000000009LL;
const int MAX = 100000;
long long d[1000001][4];

int main() {
    d[1][1] = d[2][2] = d[3][3] = 1;
    for(int i = 3; i <= MAX; i++) {
        for(int j = 1; j <= 3; j++) {
            for(int k = 1; k <= 3; k++) {
                if(j == k) {
                    continue;
                }
                d[i][j] += d[i - j][k];
            }
            d[i][j] %= DIV;
        }
    }

    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        cout << (d[n][1] + d[n][2] + d[n][3]) % DIV << '\n';
    }

    return 0;
}