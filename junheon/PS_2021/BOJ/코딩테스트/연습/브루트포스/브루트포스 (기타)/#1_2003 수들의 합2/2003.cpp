#include <iostream>

using namespace std;
int a[10000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int ans = 0;
    for(int i = 0; i < n; i++) {
        int sum = 0;
        for(int j = i; j < n; j++) {
            sum += a[j];
            if(sum == m) {
                ans++;
                break;
            }
        }
    }

    // output
    cout << ans << '\n';
    return 0;
}