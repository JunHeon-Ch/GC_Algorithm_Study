#include <iostream>
#include <algorithm>

using namespace std;
int a[1001][1001];
int c[1001][1001];

int main() {
    // input
    int n, m;
    cin >> n >> m;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            cin >> a[i][j];
        }
    }

    // operation
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            c[i][j] = a[i][j] + max({c[i - 1][j - 1], c[i - 1][j], c[i][j - 1]});
        }
    }

    // output
    cout << c[n][m] << '\n';
    return 0;
}