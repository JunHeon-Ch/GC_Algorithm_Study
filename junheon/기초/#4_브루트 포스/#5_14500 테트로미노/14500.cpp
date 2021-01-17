#include <iostream>

using namespace std;
int a[500][500];

int main() {
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    int ans = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(j + 3 < m) {
                int tmp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i][j + 3];
                ans = max(ans, tmp);
            }
            if(i + 3 < n) {
                int tmp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 3][j];
                ans = max(ans, tmp);   
            }
            if(i + 2 < n && j + 1 < m) {
                int tmp = a[i][j] + a[i + 1][j] + a[i + 2][j];
                int tmp1 = tmp + a[i][j + 1];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i + 1][j + 1];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i + 2][j + 1];
                ans = max(ans, tmp1);
            }
            if(i + 2 < n && j - 1 >= 0) {
                int tmp = a[i][j] + a[i + 1][j] + a[i + 2][j];
                int tmp1 = tmp + a[i][j - 1];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i + 1][j - 1];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i + 2][j - 1];
                ans = max(ans, tmp1);               
            }
            if(j + 2 < m && i + 1 < n) {
                int tmp = a[i][j] + a[i][j + 1] + a[i][j + 2];
                int tmp1 = tmp + a[i + 1][j];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i + 1][j + 1];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i + 1][j + 2];
                ans = max(ans, tmp1); 
            }
            if(j + 2 < m && i - 1 >= 0) {
                int tmp = a[i][j] + a[i][j + 1] + a[i][j + 2];
                int tmp1 = tmp + a[i - 1][j];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i - 1][j + 1];
                ans = max(ans, tmp1);
                tmp1 = tmp + a[i - 1][j + 2];
                ans = max(ans, tmp1); 
            }
            if(i + 1 < n && j + 1 < m) {
                int tmp = a[i][j] + a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1];
                ans = max(ans, tmp);
            }
            if(i + 2 < n && j + 1 < m) {
                int tmp = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 2][j + 1];
                ans = max(ans, tmp);
            }
            if(i + 2 < n && j - 1 >= 0) {
                int tmp = a[i][j] + a[i + 1][j] + a[i + 1][j - 1] + a[i + 2][j - 1];
                ans = max(ans, tmp);
            }
            if(i + 1 < n && j + 2 < m) {
                int tmp = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j + 2];
                ans = max(ans, tmp);
            }
            if(i - 1 >= 0 && j + 2 < m) {
                int tmp = a[i][j] + a[i][j + 1] + a[i - 1][j + 1] + a[i - 1][j + 2];
                ans = max(ans, tmp);
            }
        }
    }
    cout << ans << '\n';
    
    return 0;
}