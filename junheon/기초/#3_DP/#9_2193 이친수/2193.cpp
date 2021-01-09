#include <iostream>

using namespace std;
const int MAX = 90;
const int BIT = 2;
long long d[MAX + 1][2];

int main() {
    int n;
    cin >> n;
    d[1][1] = 1;
    for(int i = 2; i <= n; i++) {
        d[i][0] = d[i - 1][0] + d[i - 1][1];
        d[i][1] = d[i - 1][0];
    }
    cout << d[n][0] + d[n][1] << '\n';

    return 0;
}