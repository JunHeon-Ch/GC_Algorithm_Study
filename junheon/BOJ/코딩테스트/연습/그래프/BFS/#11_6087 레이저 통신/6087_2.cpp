#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
struct point {
    int x, y;
};
char a[100][100];
int c[100][100];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int n, m;

int bfs(point sp, point ep) {
    memset(c, -1, sizeof(c));
    queue<point> q;
    q.push({sp.x, sp.y});
    c[sp.x][sp.y] = 0;
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        q.pop();
        if(x == ep.x && y == ep.y) return c[x][y] - 1; 
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 벽을 만나기 전까지 같은 방향으로 계속 진행
            // Keep going in the same direction until meet the wall.
            while(true) {
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) break;
                if(a[nx][ny] == '*') break;
                if(c[nx][ny] == -1) {
                    c[nx][ny] = c[x][y] + 1;
                    q.push({nx, ny});
                }
                nx += dx[i], ny += dy[i];
            }
        }
    }
    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    // input
    cin >> n >> m;
    point p[2];
    int cnt = 0;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
            if(a[i][j] == 'C') {
                p[cnt].x = i;
                p[cnt].y = j;
                cnt++;
            }
        }
    }
    
    int ans = bfs(p[0], p[1]);

    // output
    cout << ans << '\n';
    return 0;
}
