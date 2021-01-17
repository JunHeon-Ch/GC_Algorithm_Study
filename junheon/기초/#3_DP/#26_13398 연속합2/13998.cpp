#include <iostream>

using namespace std;
int a[100001];
long long d[100001];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
        d[i] = a[i];
    }
    long long ans = a[1];
    for(int i = 0; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if(i == j) {
                d[j] = d[j - 1];
            }
            else {
                if(d[j - 1] + a[j] > a[j]) {
                    d[j] = d[j - 1] + a[j];
                }
                else {
                    d[j] = a[j];
                }
            }
            ans = max(ans, d[j]);
        }
    }
    cout << ans << '\n';
    return 0;
}