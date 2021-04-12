#include <iostream>

using namespace std;
const int MAX = 1000;
int a[MAX + 1][3];
long long d[MAX + 1][3];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 0; j < 3; j++) {
            cin >> a[i][j];
        }
    }
    long long ans = MAX * MAX + 1;
    for(int j = 0; j < 3; j++) {
        for(int i = 0; i < 3; i++) {
            if(i == j) {
                d[1][i] = a[1][i];
            }
            else {
                d[1][i] = MAX + 1;
            }
        }
        for(int i = 2; i <= n; i++) {
            d[i][0] = min(d[i - 1][1], d[i - 1][2]) + a[i][0];
            d[i][1] = min(d[i - 1][0], d[i - 1][2]) + a[i][1];
            d[i][2] = min(d[i - 1][1], d[i - 1][0]) + a[i][2];
        }
        for(int i = 0; i < 3; i++) {
            if(i == j) {
                continue;
            }
            ans = min(ans, d[n][i]);
        }
    }
    cout << ans << '\n';
    return 0;
}