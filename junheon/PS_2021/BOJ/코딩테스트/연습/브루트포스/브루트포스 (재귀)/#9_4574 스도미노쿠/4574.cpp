#include <iostream>
#include <cstring>

using namespace std;
int a[9][9];
// Possible Domino Combinations
bool c[10][10];
// Whether a number is included in the horizontal
bool check_w[9][10];
// Whether a number is included in the vertical
bool check_h[9][10];
// Whether a number is included in the 3*3 area
bool check_3x3[9][10];
int dx[] = {1, 0};
int dy[] = {0, 1};

bool check(int x, int y, int k) {
    if(!(check_w[x][k] || check_h[y][k] || check_3x3[x / 3 * 3 + y / 3][k])) return true;
    return false;
}

bool sudominoku(int x, int y) {
    if(x == 9) return true;
    // blank
    if(a[x][y] == 0) {
        // find possible domino
        for(int k = 0; k < 2; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx > 8 || ny > 8 || a[nx][ny] != 0) continue;
            for(int i = 1; i < 10; i++) {
                for(int j = 1; j < 10; j++) {
                    if(i != j && !c[i][j]) {
                        // check sudoku
                        if(check(x, y, i) && check(nx, ny, j)) {
                            a[x][y] = i; a[nx][ny] = j;
                            c[i][j] = true; c[j][i] = true;
                            check_w[x][i] = true; check_h[y][i] = true; check_3x3[x / 3 * 3 + y / 3][i] = true;
                            check_w[nx][j] = true; check_h[ny][j] = true; check_3x3[nx / 3 * 3 + ny / 3][j] = true;

                            // move point
                            int cx, cy;
                            if(y < 8) {
                                cx = x; cy = y + 1;
                            }
                            else {
                                cx = x + 1; cy = 0;
                            }
                            if(sudominoku(cx, cy)) return true;

                            a[x][y] = 0; a[nx][ny] = 0;
                            c[i][j] = false; c[j][i] = false;
                            check_w[x][i] = false; check_h[y][i] = false; check_3x3[x / 3 * 3 + y / 3][i] = false;
                            check_w[nx][j] = false; check_h[ny][j] = false; check_3x3[nx / 3 * 3 + ny / 3][j] = false;

                        }
                    }
                }
            }
        }
    }
    // filled
    else {
        int cx, cy;
        if(y < 8) {
            cx = x; cy = y + 1;
        }
        else {
            cx = x + 1; cy = 0;
        }
        if(sudominoku(cx, cy)) return true;
    }

    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int cnt = 0;
    while(true) {
        // input
        int n;
        cin >> n;
        if(n == 0) break;
        cnt++;

        memset(a, 0, sizeof(a));
        memset(c, false, sizeof(c));
        memset(check_w, false, sizeof(check_w));
        memset(check_h, false, sizeof(check_h));
        memset(check_3x3, false, sizeof(check_3x3));

        int v1, v2, x, y;
        char r1, r2, c1, c2;
        for(int i = 0; i < n; i++) {
            cin >> v1;
            cin >> r1 >> c1;
            x = r1 - 'A'; y = c1 - '1';
            a[x][y] = v1;
            check_w[x][v1] = true;
            check_h[y][v1] = true;
            check_3x3[x / 3 * 3 + y / 3][v1] = true;

            cin >> v2;
            cin >> r2 >> c2;
            x = r2 - 'A'; y = c2 - '1';
            a[x][y] = v2;
            check_w[x][v2] = true;
            check_h[y][v2] = true;
            check_3x3[x / 3 * 3 + y / 3][v2] = true;

            c[v1][v2] = true;
            c[v2][v1] = true;
        }
        for(int i = 1; i < 10; i++) {
            cin >> r1 >> c1;
            x = r1 - 'A'; y = c1 - '1';
            a[x][y] = i;
            c[i][i] = true;
            check_w[x][i] = true;
            check_h[y][i] = true;
            check_3x3[x / 3 * 3 + y / 3][i] = true;
        }

        sudominoku(0, 0);

        // output
        cout << "Puzzle " << cnt << '\n';
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                cout << a[i][j];
            }
            cout << '\n';
        }
    }
}