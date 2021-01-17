#include <iostream>
#include <algorithm>

using namespace std;
int d[10001];
int c[10001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> c[i]; 
    }
    d[1] = c[1];
    d[2] = c[1] + c[2];
    for(int i = 3; i <= n; i++) {
        d[i] = max({d[i - 1], d[i - 2] + c[i], d[i - 3] + c[i - 1] + c[i]});
    }
    cout << d[n] << '\n';
    return 0;
}