// recursive

#include <iostream>

using namespace std;
char a[10][10];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int ans = -1;

void go(int rx, int ry, int bx, int by, int dir, int cnt) {
    // escape condition
    if(cnt > 10) return;
    int nrx, nry, nbx, nby;
    if(dir != -1) {
        nbx = bx + dx[dir];
        nby = by + dy[dir];
        nrx = rx + dx[dir];
        nry = ry + dy[dir];
        // blue
        while(a[nbx][nby] != '#' && a[nbx][nby] != 'O') {
            nbx = nbx + dx[dir];
            nby = nby + dy[dir];
        }
        // red
        while(a[nrx][nry] != '#' && a[nrx][nry] != 'O') {
            nrx = nrx + dx[dir];
            nry = nry + dy[dir];
        }
        // escape condition
        if(a[nbx][nby] == 'O') return;
        if(a[nrx][nry] == 'O') {
            if(ans == -1 || ans > cnt) ans = cnt;
            return;
        }
        nrx -= dx[dir]; nry -= dy[dir];
        nbx -= dx[dir]; nby -= dy[dir];
        if(nrx == nbx && nry == nby) {
            if(abs(nrx - rx) + abs(nry - ry) < abs(nbx - bx) + abs(nby - by)) {
                bx = nbx - dx[dir];
                by = nby - dy[dir];
                rx = nrx; ry = nry;
            }            
            else {
                rx = nrx - dx[dir];
                ry = nry - dy[dir];
                bx = nbx; by = nby;
            }
        }
        else {
            bx = nbx; by = nby;
            rx = nrx; ry = nry;
        }
    }
    // different direction
    for(int i = 0; i < 4; i++) {
        if(i == dir) continue;
        nrx = rx + dx[i];
        nry = ry + dy[i];
        nbx = bx + dx[i];
        nby = by + dy[i];
        if(a[nrx][nry] == '#' && a[nbx][nby] == '#') continue;
        go(rx, ry, bx, by, i, cnt + 1);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, m;
    cin >> n >> m;
    int rx, ry, bx, by;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
            if(a[i][j] == 'R') {
                rx = i; ry = j;
            }
            else if(a[i][j] == 'B') {
                bx = i; by = j;
            }
        }
    }

    go(rx, ry, bx, by, -1, 0);

    // output
    cout << ans << '\n';
    return 0;
}