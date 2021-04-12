#include <iostream>
#include <algorithm>

using namespace std;
const int MAX = 100000;
long long d[MAX + 1][3];
int cost[2][MAX + 1];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= n; j++) {
                cin >> cost[i][j];
            }
        }
        d[1][0] = cost[0][1]; d[1][1] = cost[1][1]; d[1][2] = 0;
        for(int i = 2; i <= n; i++) {
            d[i][0] = max(d[i - 1][1], d[i - 1][2]) + cost[0][i];
            d[i][1] = max(d[i - 1][0], d[i - 1][2]) + cost[1][i];
            d[i][2] = max({d[i - 1][0], d[i - 1][1], d[i - 1][2]});
        }
        cout << max({d[n][0], d[n][1], d[n][2]}) << '\n';
    }
    return 0;
}