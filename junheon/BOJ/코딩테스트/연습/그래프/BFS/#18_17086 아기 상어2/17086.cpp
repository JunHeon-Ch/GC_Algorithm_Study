#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
int a[50][50];
int d[50][50];
int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};
int dy[] = {-1, 1, 0, 0, -1, 1, 1, -1};

int main() {
    // input
    int n, m;
    cin >> n >> m;
    queue<pair<int, int>> q;
    memset(d, -1, sizeof(d));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
            if(a[i][j] == 1) {
                q.push({i, j});
                d[i][j] = 0;
            }
        }
    }

    // bfs
    int ans = 0;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(d[nx][ny] != -1) continue;
            d[nx][ny] = d[x][y] + 1;
            ans = max(ans, d[nx][ny]);
            q.push({nx, ny});
        }
    }

    // output
    cout << ans << '\n';
    return 0;
}