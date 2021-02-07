#include <iostream>
 
using namespace std;
 
int a[300][300];
int ans[300][300];
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, r;
    cin >> n >> m >> r;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    // 회전방향 : 왼쪽, 위, 오른쪽, 아래
    while (r--) {
        int x1 = 0;
        int y1 = 0;
 
        int x2 = n - 1;
        int y2 = 0;
 
        int x3 = n - 1;
        int y3 = m - 1;
 
        int x4 = 0;
        int y4 = m - 1;
        while ((x1 < x2) && (y1 < y4)) {
            int tmp = a[x2][y2];
            for (int i = x2; i > x1; i--) {
                a[i][y2] = a[i - 1][y2];
            }
            for (int j = y1; j < y4; j++) {
                a[x1][j] = a[x1][j + 1];
            }
            for (int i = x4; i < x3; i++) {
                a[i][y4] = a[i + 1][y4];
            }
            for (int j = y3; j > y2; j--) {
                a[x3][j] = a[x3][j - 1];
            }
            a[x2][y2 + 1] = tmp;
            x1++; y1++; 
            x2--; y2++;
            x3--; y3--;             
            x4++; y4--;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }
}