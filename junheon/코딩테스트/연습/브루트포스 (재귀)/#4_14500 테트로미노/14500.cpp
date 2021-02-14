#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int a[500][500];
bool c[500][500];
// clockwise
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int n, m;
int ans = 0;

// Tetromino with three consecutive block in one direction
// eg
// o      |  o o o o
// o o o  |
void goThree(int x, int y, int dir, int cnt, int res) {
    // escape condition
    if(cnt == 3) {
        for(int j = 0; j < cnt; j++) {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!c[nx][ny]) {
                        ans = max(ans, res + a[nx][ny]);
                    }
                }
            }
            int revDir = (dir + 2) % 4;
            x += dx[revDir]; y += dy[revDir];
        }
        return;
    }
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if(!c[nx][ny]) {
            c[nx][ny] = true;
            goThree(nx, ny, dir, cnt + 1, res + a[nx][ny]);
            c[nx][ny] = false;
        }
    }
}

// Tetromino with two consecutive block in one direction
// e.g)
// o o  |  o
// o o  |  o o
//           o
void goTwo(int x, int y, int dir, int cnt, int res) {
    if(cnt == 4) {
        ans = max(ans, res);
        return;
    }
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if(!c[nx][ny]) {
            c[nx][ny] = true;
            goTwo(nx, ny, (dir + 1) % 4, cnt + 1, res + a[nx][ny]);
            goTwo(nx, ny, (dir + 3) % 4, cnt + 1, res + a[nx][ny]);
            c[nx][ny] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            // check only left and bottom
            for(int k = 0; k < 2; k++) {
                c[i][j] = true;
                goThree(i, j, k, 1, a[i][j]);
                goTwo(i, j, k, 1, a[i][j]);
                c[i][j] = false;
            }
        }
    }

    // output
    cout << ans << '\n';
    return 0;
}