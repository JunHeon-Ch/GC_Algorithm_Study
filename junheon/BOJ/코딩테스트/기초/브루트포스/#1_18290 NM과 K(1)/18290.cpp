#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <tuple>

using namespace std;
int a[10][10];
int c[10][10];
int dx[] = {0, 0, 0, -1, 1};
int dy[] = {0, -1, 1, 0, 0};
int n, m, k;
int ans = -1000000;

void go(int cnt, int sum) {
    if(cnt > k) return;
    if(cnt == k) {
        ans = max(ans, sum);
        return;
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(c[i][j] == 0) {
                for(int l = 0; l < 5; l++) {
                    int nx = i + dx[l];
                    int ny = j + dy[l];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        c[nx][ny]++;
                    }
                }
                go(cnt + 1, sum + a[i][j]);
                for(int l = 0; l < 5; l++) {
                    int nx = i + dx[l];
                    int ny = j + dy[l];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        c[nx][ny]--;
                    }
                }
            }
        }
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    go(0, 0);
    cout << ans << '\n';
    return 0;
}