`#include <iostream>

using namespace std;
long long d1[1001], d2[1001];
int a[1001];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    for(int i = 1; i <= n; i++) {
        d1[i] = 1;
        for(int j = 1; j < i; j++) {
            if(a[i] > a[j] && d1[j] + 1 > d1[i]) {
                d1[i] = d1[j] + 1;
            }
        }
    }
    for(int i = n; i >= 1; i--) {
        d2[i] = 1;
        for(int j = n; j > i; j--) {
            if(a[i] > a[j] && d2[j] + 1 > d2[i]) {
                d2[i] = d2[j] + 1;
            }
        }
    }
    long long ans = d1[1] + d2[1];
    for(int i = 2; i <= n; i++) {
        ans = max(ans, d1[i] + d2[i]);
    }
    cout << ans - 1 << '\n';
    return 0;
}
