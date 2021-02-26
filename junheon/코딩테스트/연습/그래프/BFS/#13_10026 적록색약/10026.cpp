#include <iostream>
#include <queue>

using namespace std;
char a[2][100][100];
bool c[2][100][100];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n;

void bfs(int sx, int sy, int d) {
    queue<pair<int, int>> q;
    q.push(make_pair(sx, sy));
    c[d][sx][sy] = true;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(c[d][nx][ny]) continue;
            if(a[d][nx][ny] != a[d][x][y]) continue;
            c[d][nx][ny] = true;
            q.push(make_pair(nx, ny));
        }
    }
} 

int main() {
    // input
    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[0][i][j];
            a[1][i][j] = a[0][i][j];
            if(a[0][i][j] == 'G') {
                a[1][i][j] = 'R';
            }
        }
    }

    int cnt1 = 0, cnt2 = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(!c[0][i][j]) {
                cnt1++;
                bfs(i, j, 0);
            }
            if(!c[1][i][j]) {
                cnt2++;
                bfs(i, j, 1);
            }
        }
    }

    // output
    cout << cnt1 << ' ';
    cout << cnt2 << '\n';
    return 0;
}