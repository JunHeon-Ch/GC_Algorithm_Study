#include <iostream>
#include <cstring>

using namespace std;
int a[501][501];
int s[501];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        memset(a, 0, sizeof(a));
        memset(s, 0, sizeof(s));
        for(int i = 1; i <= n; i++) {
            int num;
            cin >> num;
            s[i] = s[i - 1] + num;
        }
        for(int r = 1; r < n; r++) {
            for(int x = 1; x + r <= n; x++) {
                int y = x + r;
                for(int k = x; k < y; k++) {
                    int res = a[x][k] + a[k + 1][y] + s[y] - s[x - 1];
                    if(a[x][y] == 0 || a[x][y] > res) {
                        a[x][y] = res;
                    }
                }
            }
        }
        cout << a[1][n] << '\n';
    }
    return 0;
}