#include <iostream>

using namespace std;
const int N = 0;
const int E = 1;
const int S = 2;
const int W = 3;
int a[50][50];
// Left coordinate by current direction
int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int n, m;
    cin >> n >> m;
    int r, c, d;
    cin >> r >> c >> d;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    int ans = 0;
    while(true) {
        // clean current position
        if(a[r][c] == 0) {
            ans++;
            a[r][c] = 2;
        }
        // Check four directions based on the current direction
        int i;
        for(i = 0; i < 4; i++) {
            int nx = r + dx[d];
            int ny = c + dy[d];
            // rotate direction
            if(d == N) d = W;
            else if(d == W) d = S;
            else if(d == S) d = E;
            else if(d == E) d = N;
            if(a[nx][ny] == 0) {
                r = nx;
                c = ny;
                break;
            }
        }
        // If all four directions are already cleaned or a wall
        if(i == 4) {
            bool flag = false;
            switch(d) {
                case N:
                if(r + 1 < n && a[r + 1][c] != 1) r++;
                else flag = true;
                break;
                case S:
                if(r - 1 >= 0 && a[r - 1][c] != 1) r--;
                else flag = true;
                break;
                case E:
                if(c - 1 >= 0 && a[r][c - 1] != 1) c--;
                else flag = true;
                break;
                case W:
                if(c + 1 < m && a[r][c + 1] != 1) c++;
                else flag = true;
                break;
            }
            // Backward direction is wall and cannot be reversed
            if(flag) {
                cout << ans << '\n';
                break;
            }
        }
    }

    return 0;
}