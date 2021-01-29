// 인접 행렬을 이용한 bfs

#include <iostream>
#include <cstdio>
#include <queue>
#include <algorithm>

using namespace std;
int g[101][101];
int dist[101][101];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n, m;

void bfs(int sx, int sy) {
    queue<pair<int, int>> q;
    dist[sx][sy] = 1;
    q.push(make_pair(sx, sy));
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                if(dist[nx][ny] == 0 && g[nx][ny] == 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
}

int main() {
    scanf("%d %d", &n, &m);
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            scanf("%1d", &g[i][j]);
        }
    }
    bfs(1, 1);
    printf("%d\n", dist[n][m]);
    
    return 0;
}