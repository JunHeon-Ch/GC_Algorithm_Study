#include <iostream>
#include <algorithm>

using namespace std;
int a[100001];
long long dl[100001];
long long dr[100001];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
        dl[i] = a[i];
        dr[i] = a[i];
    }
    for(int i = 2; i <= n; i++) {
        dl[i] = max(dl[i], dl[i - 1] + a[i]);
    }
    for(int i = n - 1; i >= 1; i--) {
        dr[i] = max(dr[i], dr[i + 1] + a[i]);
    }
    long long ans = *max_element(dl + 1, dl + n + 1);
    for(int i = 2; i <= n - 1; i++) {
        ans = max(ans, dl[i - 1] + dr[i + 1]);
    }
    // for(int i = 1; i <= n; i++) {
    //     if(i == 1) {
    //         ans = max(ans, dr[i + 1]);
    //     }
    //     else if(i == n) {
    //         ans = max(ans, dl[n - 1]);
    //     }
    //     else {
    //         ans = max(ans, dl[i - 1] + dr[i + 1]);
    //     }
    // }
    cout << ans << '\n';
    return 0;
}