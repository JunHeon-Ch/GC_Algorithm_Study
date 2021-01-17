#include <iostream>

using namespace std;
long long d[10001][2];
int cost[10001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> cost[i];
    }
    d[1][0] = cost[1];
    d[2][0] = d[1][0] + cost[2];
    d[2][1] = d[1][0];
    for(int i = 3; i <= n; i++) {
        d[i][0] = max(d[i - 1][1], d[i - 2][1] + cost[i - 1]) + cost[i];
        d[i][1] = max(d[i - 1][0], d[i - 1][1]);
    }
    cout << max(d[n][0], d[n][1]) << '\n';

    return 0;
} 