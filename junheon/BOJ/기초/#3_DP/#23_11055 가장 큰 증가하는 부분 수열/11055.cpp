#include <iostream>
#include <algorithm>

using namespace std;
int a[1001];
long long d[1001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    for(int i = 1; i <= n; i++) {
        d[i] = a[i];
        for(int j = 1; j < i; j++) {
            if(a[i] > a[j] && d[i] < d[j] + a[i]) {
                d[i] = d[j] + a[i];
            }
        }
    }
    cout << *max_element(d + 1, d + n + 1) << '\n';
    return 0;
}