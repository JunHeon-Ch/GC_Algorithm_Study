// fail
#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
struct point {
    int x, y, d;
};
char a[100][100];
int c[100][100];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m;
point p[2];

void bfs(point sp, point ep) {
    queue<point> q;
    queue<point> nq;
    q.push({sp.x, sp.y, sp.d});
    memset(c, -1, sizeof(c));
    c[sp.x][sp.y] = 0;
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int d = q.front().d;
        q.pop();
        if(x == ep.x && y == ep.y) return; 
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(c[nx][ny] != -1) continue;
            if(a[nx][ny] == '*') continue;
            if(a[nx][ny] == '.' || a[nx][ny] == 'C') {
                // same direction
                if(d == -1 || d == i) {
                    c[nx][ny] = c[x][y];
                    q.push({nx, ny, i});
                }
                // different direction
                else {
                    c[nx][ny] = c[x][y] + 1;
                    nq.push({nx, ny, i});
                }
            }
        }
        if(q.empty()) {
            q = nq;
            nq = queue<point>();
        }
    }
}

int main() {
    // input
    cin >> n >> m;
    int cnt = 0;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
            if(a[i][j] == 'C') {
                p[cnt].x = i;
                p[cnt].y = j;
                p[cnt].d = -1;
                cnt++; 
            }
        }
    }
    
    bfs(p[0], p[1]);

    // output
    cout << c[p[1].x][p[1].y] << '\n';
    return 0;
}
