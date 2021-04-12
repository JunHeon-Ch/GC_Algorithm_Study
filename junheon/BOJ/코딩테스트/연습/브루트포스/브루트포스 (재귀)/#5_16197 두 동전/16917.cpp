#include <iostream>

using namespace std;
int a[22][22]; // 0 -> blank / 1 -> wall / 2 -> cliff
bool c1[22][22];
bool c2[22][22];
int n, m;
int ans = -1;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void go(int x, int y, int z, int w, int cnt) {
    // escape condition
    // More than 10 times
    if(cnt > 10) {
        return;
    }
    // If only one of the two falls.
    if(a[x][y] == 2 || a[z][w] == 2) {
        if(ans == -1 || ans > cnt) {
            ans = cnt;
        }
        return;
    }
    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        int nz = z + dx[i];
        int nw = w + dy[i];

        if(!c1[nx][ny] && !c2[nz][nw]) {
            // Two coins must not fall at the same time -> change direction
            if(a[nx][ny] == 2 && a[nz][nw] == 2) continue;
            // If both of them hit the wall, change direction
            if(a[nx][ny] == 1 && a[nz][nw] == 1) continue;
            // If only one coin hits the wall,
            if(a[nx][ny] == 1) {
                c2[nz][nw] = true;
                go(x, y, nz, nw, cnt + 1);
            }
            else if(a[nz][nw] == 1) {
                c1[nx][ny] = true;
                go(nx, ny, z, w, cnt + 1);
            }
            else {
                c1[nx][ny] = true;
                c2[nz][nw] = true;
                go(nx, ny, nz, nw, cnt + 1);
            }
            c1[nx][ny] = false;
            c2[nz][nw] = false;
        }
        
    }
}

int main() {
    // input
    cin >> n >> m;
    int idx = 0;
    int x, y, z, w;
    for(int i = 0; i <= n + 1; i++) {
        for(int j = 0; j <= m + 1; j++) {
            if(i == 0 || i == n + 1 || j == 0 || j == m + 1) {
                a[i][j] = 2;
            }
            else {
                char temp;
                cin >> temp;
                if(temp == '#') {
                    a[i][j] = 1;
                }
                else if(temp == 'o') {
                    if(idx == 0) {
                        x = i; y = j;
                    }
                    else {
                        z = i; w = j;
                    }
                    idx++;
                }
            }
        }
    }
    
    a[x][y] = true;
    a[z][w] = true;
    go(x, y, z, w, 0);

    // output
    cout << ans << '\n';
    return 0;
}