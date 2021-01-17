#include <iostream>

using namespace std;
int cost[501][501];
long long d[501][501];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= i; j++) {
            cin >> cost[i][j];
        }
    }
    d[1][1] = cost[1][1];
    for(int i = 2; i <= n; i++) {
        for(int j = 1; j <= i; j++) {
            if(j == 1) {
                d[i][j] = d[i - 1][j] + cost[i][j];
            }
            else if(j == i) {
                d[i][j] = d[i - 1][j - 1] + cost[i][j];
            }
            else {
                d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + cost[i][j];
            }
        }
    }
    long long max = d[n][1];
    for(int i = 2; i <= n; i++) {
        if(d[n][i] > max) {
            max = d[n][i];
        }
    }
    cout << max << '\n';

    return 0;
}