#include <cstdio>
#include <queue>

using namespace std;
struct map {
    int x, y, w;
};
int a[1001][1001];
// 0 -> no break / 1 -> break
int c[1001][1001][2];
int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};
int n, m;
int ans = -1;

void bfs() {
    queue<map> q;
    q.push({1, 1, 0});
    c[1][1][0] = 1;
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int w = q.front().w;
        q.pop();
        if(x == n && y == m) {
            if(ans == -1 || ans > c[x][y][w]) {
                ans = c[x][y][w];
                return;
            }
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
            if(c[nx][ny][w] > 0) continue;
            if(a[nx][ny] == 0 && c[nx][ny][w] == 0) {
                q.push({nx, ny, w});
                c[nx][ny][w] = c[x][y][w] + 1;
            }
            if(a[nx][ny] == 1 && w == 0) {
                q.push({nx, ny, 1});
                c[nx][ny][1] = c[x][y][w] + 1;
            }
        }
    }
}

int main() {
    // input
    scanf("%d %d", &n, &m);
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            scanf("%1d", &a[i][j]);
        }
    }

    bfs();

    // output
    printf("%d\n", ans);
    return 0;
}