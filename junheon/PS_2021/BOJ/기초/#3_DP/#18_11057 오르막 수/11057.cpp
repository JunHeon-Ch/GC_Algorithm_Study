#include <iostream>

using namespace std;
const int MOD = 10007;
const int MAX = 1000;
const int DIGIT = 10;
int d[MAX + 1][DIGIT];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        d[i][0] = 1;
    }
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j < DIGIT; j++) {
            d[i][j] = (d[i - 1][j] + d[i][j - 1]) % MOD;
        }
    }
    long long sum = 0;
    for(int i = 0; i < DIGIT; i++) {
        sum += d[n][i];
    }
    cout << sum % MOD << '\n';
        
    return 0;
}