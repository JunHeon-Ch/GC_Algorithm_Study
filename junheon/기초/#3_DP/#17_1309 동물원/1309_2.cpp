#include <iostream>

using namespace std;
const int MOD = 9901;
int d[100001];
int s[100001];

int main() {
    int n;
    cin >> n;
    d[0] = 1;
    d[1] = 2;
    s[0] = 1;
    s[1] = s[0] + d[1];
    for(int i = 2; i <= n; i++) {
        d[i] = (d[i - 1] + 2 * s[i - 2]) % MOD;
        s[i] = (s[i - 1] + d[i]) % MOD;
    }
    cout << s[n] << '\n';
    return 0;
}