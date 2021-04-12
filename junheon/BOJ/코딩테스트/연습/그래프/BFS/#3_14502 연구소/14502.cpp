#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
int a[8][8];
int tmp_a[8][8];
bool dc[8][8];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m;
int ans = 0;

void bfs() {
    queue<pair<int, int>> q;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(a[i][j] == 2) {
                q.push(make_pair(i, j));
            }
        }
    }
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(tmp_a[nx][ny] == 0) {
                    tmp_a[nx][ny] = 2;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
}

void go(int x, int y, int cnt) {
    if(cnt == 3) {
        // Spread of the virus
        memcpy(tmp_a, a, sizeof(a));
        bfs();
        // Find safety zone size
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tmp_a[i][j] == 0) res++;
            }
        }
        ans = max(ans, res);
        return;
    }
    for(int i = x; i < n; i++) {
        int tmp_y = 0;
        if(i == x) tmp_y = y;
        for(int j = tmp_y; j < m; j++) {
            if(!dc[i][j]) {
                if (a[i][j] == 0) {
                    dc[i][j] = true;
                    a[i][j] = 1;
                    go(i, j + 1, cnt + 1);
                    dc[i][j] = false;
                    a[i][j] = 0;
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
            if(a[i][j] != 0) dc[i][j] = true;
        }
    }

    // Put 3 Walls
    go(0, 0, 0);

    // output
    cout << ans << '\n';
    return 0;
}