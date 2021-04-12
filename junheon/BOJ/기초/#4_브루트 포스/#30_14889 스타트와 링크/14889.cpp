#include <iostream>
#include <algorithm>

using namespace std;
int s[21][21];
int t[21];

int main() {
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        if(i > n / 2) {
            t[i] = 1;
        }
        for(int j = 1;j <= n; j++) {
            cin >> s[i][j];
        }
    }

    int ans = -1;
    do {
        int l = 0, r = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(t[i] == 1 && t[j] == 1) {
                    r += s[i][j] + s[j][i];
                }
                else if(t[i] == 0 && t[j] == 0) {
                    l += s[i][j] + s[j][i];
                }
            }
        }
        if(ans == -1 || ans > abs(l - r)) {
            ans = abs(l - r);
        }
    } while(next_permutation(t + 1, t + n + 1));
    cout << ans << '\n';

    return 0;
}