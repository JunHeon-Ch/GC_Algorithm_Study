// 인접행렬을 이용한 bfs

#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;
int g[300][300];
int c[300][300];
int dx[] = {-1, -2, -2, -1, 1, 2, 1, 2};
int dy[] = {-2, -1, 1, 2, -2, -1, 2, 1};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        memset(c, -1, sizeof(c));
        memset(g, 0, sizeof(g));

        queue<pair<int, int>> q;
        int sx, sy, fx, fy;
        cin >> sx >> sy;
        q.push(make_pair(sx, sy));
        c[sx][sy] = 0;
        cin >> fx >> fy;
        g[fx][fy] = 1;
        
        int ans = 0;
        while(!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();

            if(g[x][y] == 1) {
                cout << c[x][y] << '\n';
                break;
            }

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(c[nx][ny] == -1) {
                        c[nx][ny] = c[x][y] + 1;
                        q.push(make_pair(nx, ny));
                    }
                }
            }
        }
        
    }
    return 0;
}
