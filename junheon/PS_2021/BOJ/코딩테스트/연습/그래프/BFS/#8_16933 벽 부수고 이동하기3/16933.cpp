#include <cstdio>
#include <queue>

using namespace std;
struct map {
    int x, y, w, d;
};
int a[1000][1000];
bool c[1000][1000][11];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m, k;

int bfs() {
    queue<map> q;
    q.push({0, 0, 0, 1});
    c[0][0][0] = true;
    bool day = true;
    while(!q.empty()) {
        int size = q.size();
        while(size--) {
            int x = q.front().x;
            int y = q.front().y;
            int w = q.front().w;
            int d = q.front().d;
            q.pop();
            if(x == n - 1 && y == m - 1) return d;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // don't break the wall
                if(a[nx][ny] == 0) {
                    if(c[nx][ny][w]) continue;
                    c[nx][ny][w] = true;
                    q.push({nx, ny, w, d + 1});
                }
                // break the wall
                else {
                    // Up to k walls can be broken and only during the day
                    if(w >= k) continue;
                    if(c[nx][ny][w + 1]) continue;
                    // It can move because it's daytim.
                    if(day) {
                        c[nx][ny][w + 1] = true;
                        q.push({nx, ny, w + 1, d + 1});
                    }
                    // It can't move because it's night
                    else {
                        q.push({x, y, w, d + 1});
                    }
                }
            }
        }
        day = !day;
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