// 인접 행렬을 이용한 bfs

#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
int g[1000][1000];
int c[1000][1000];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int m, n;
    cin >> m >> n;
    queue<pair<int, int>> q;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> g[i][j];
            c[i][j] = -1;
            if(g[i][j] == 1) {
                q.push(make_pair(i, j));
                c[i][j] = 0;
            }
        }
    }

    // bfs
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(g[nx][ny] == 0 && c[nx][ny] == -1) {
                    q.push(make_pair(nx, ny));
                    c[nx][ny] = c[x][y] + 1;
                }
            }
        }
    }

    int ans = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(c[i][j] == -1 && g[i][j] == 0) {
                ans = -1;
                cout << ans << '\n';
                return 0;
            }
            ans = max(ans, c[i][j]);
        }
    }    
    cout << ans << '\n';

    return 0;
}