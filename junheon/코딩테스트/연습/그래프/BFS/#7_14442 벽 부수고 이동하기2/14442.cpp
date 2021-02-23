#include <cstdio>
#include <queue>

using namespace std;
struct map {
    int x, y, w;
};
int a[1000][1000];
int c[1000][1000][11];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m, k;

int bfs() {
    queue<map> q;
    q.push({0, 0, 0});
    c[0][0][0] = 1;
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int w = q.front().w;
        q.pop();
        if(x == n - 1 && y == m - 1) {
            return c[x][y][w];
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // don't break the wall
                if(a[nx][ny] == 0) {
                    if(c[nx][ny][w] != 0) continue;
                    c[nx][ny][w] = c[x][y][w] + 1;
                    q.push({nx, ny, w});
                }
                // break the wall
                else if(a[nx][ny] == 1) {
                    if(w >= k || c[nx][ny][w + 1] != 0) continue;
                    c[nx][ny][w + 1] = c[x][y][w] + 1;
                    q.push({nx, ny, w + 1});
                }
            }
        }
    }
    return -1;
}

int main() {
    // input
    scanf("%d %d %d", &n, &m, &k);
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            scanf("%1d", &a[i][j]);
        }
    }

    int ans = bfs();

    // output
    printf("%d\n", ans);
    return 0;
}