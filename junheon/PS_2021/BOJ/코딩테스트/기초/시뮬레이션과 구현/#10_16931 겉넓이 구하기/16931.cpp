#include <iostream>

using namespace std;
int a[100][100];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    // input
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    // caculate surface area
    int ans = 0;
    int sum = 0;
    // vertical
    for(int j = 0; j < m; j++) {
        sum += a[0][j];
        for(int i = 1; i < n; i++) {
            if(a[i - 1][j] < a[i][j]) {
                sum += a[i][j] - a[i - 1][j];
            }
        }
    }
    ans += 2 * sum;
    sum = 0;
    // horizontal
    for(int i = 0; i < n; i++) {
        sum += a[i][0];
        for(int j = 1; j < m; j++) {
            if(a[i][j - 1] < a[i][j]) {
                sum += a[i][j] - a[i][j - 1];
            }
        }
    }
    // top & bottom
    ans += 2 * sum;
    sum = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(a[i][j] != 0) {
                sum++;
            }
        }
    }
    ans += 2 * sum;
    
    // output
    cout << ans << '\n';
    return 0;
}