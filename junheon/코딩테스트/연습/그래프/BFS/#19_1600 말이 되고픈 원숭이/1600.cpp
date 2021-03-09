#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
struct map {
    int x, y, c;
};
int a[200][200];
int d[200][200][31];
int dx[] = {0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
int dy[] = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};
int w, h, k;

int bfs() {
    memset(d, -1, sizeof(d));
    queue<map> q;
    q.push({0, 0, 0});
    d[0][0][0] = 0;
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int c = q.front().c;
        q.pop();
        if(x == h - 1 && y == w - 1) {
            return d[x][y][c];
        }
        int n;
        if(c < k) n = 12;
        else n = 4;
        for(int i = 0; i < n; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nc = c;
            if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if(a[nx][ny] == 1) continue;
            if(i < 4 && d[nx][ny][c] != -1) continue;
            if(i >= 4 && d[nx][ny][c + 1] != -1) continue;
            if(i >= 4) nc++;
            d[nx][ny][nc] = d[x][y][c] + 1;
            q.push({nx, ny, nc});
        }
    }
    return -1;
}

int main() {
    // input
    cin >> k >> w >> h;
    for(int i = 0; i < h; i++) {
        for(int j = 0; j < w; j++) {
            cin >> a[i][j];
        }
    }

    int ans = bfs();

    // output
    cout << ans << '\n';
    return 0;
}