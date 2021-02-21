#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
int a[50][50];
int dx[] = {0, 0, -1, 1, -1, 1};
int dy[] = {-1, 1, 0, 0, 1, -1};
int n;
int ans = 0;

void bfs(int sx, int sy) {
    queue<pair<int, int>> q;
    q.push(make_pair(sx, sy));
    a[sx][sy] = 0;
    ans = max(ans, 1);
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nc = 1 - a[x][y];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(a[nx][ny] == a[x][y]) {
                    ans = max(ans, 3);
                    return;
                }
                if(a[nx][ny] == -1) {
                    q.push(make_pair(nx, ny));
                    a[nx][ny] = nc;
                    ans = max(ans, 2);
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            char c;
            cin >> c;
            if(c == '-') a[i][j] = -2;
            else if(c == 'X') a[i][j] = -1;
        }
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(a[i][j] == -1) bfs(i, j);
        }
    }

    // output
    cout << ans << '\n';
    return 0;
}