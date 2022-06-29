#include <iostream>

using namespace std;
const int MAX = 1000000;
long long f[MAX + 1];
long long g[MAX + 1];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    fill_n(f, MAX + 1, 1);
    for(int i = 2; i <= MAX; i++) {
        for(int j = 1; i * j <= MAX; j++) {
            f[i * j] += i;
        }
    }    
    for(int i = 1; i <= MAX; i++) {
        g[i] = g[i - 1] + f[i];
    }
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        cout << g[n] << '\n';
    }
    return 0;
}