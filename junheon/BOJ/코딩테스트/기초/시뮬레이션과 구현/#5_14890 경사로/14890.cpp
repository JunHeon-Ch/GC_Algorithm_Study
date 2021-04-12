#include <iostream>

using namespace std;
int a[200][100];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, l;
    cin >> n >> l;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            a[i + n][j] = a[j][i];
        }
    }
    
    // find load
    int cnt, ans = 0;
    for(int i = 0; i < n * 2; i++) {
        cnt = 1;
        int j;
        for(j = 0; j < n - 1; j++) {
            // keep current
            if(a[i][j] == a[i][j + 1]) cnt++;
            // slope up
            else if (a[i][j] + 1 == a[i][j + 1] && cnt >= l) cnt = 1;
            // slope down
            else if (a[i][j] - 1 == a[i][j + 1] && cnt >= 0) cnt = -l + 1;
            else break;
        }
        if (j == n - 1 && cnt >= 0) ans++;
    }
    cout << ans << '\n';
    return 0;
}
