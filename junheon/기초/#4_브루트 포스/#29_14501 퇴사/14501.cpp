#include <iostream>

using namespace std;
int t[20];
int p[20];
int ans;

void maxProfit(int i, int sum, int n) {
    if(i > n) {
        return;
    }
    if(i == n) {
        ans = max(ans, sum);
        return;
    }
    maxProfit(i + t[i], sum + p[i], n);
    maxProfit(i + 1, sum, n);
}

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> t[i] >> p[i];
    }
    maxProfit(0, 0, n);
    cout << ans << '\n';

    return 0;
}