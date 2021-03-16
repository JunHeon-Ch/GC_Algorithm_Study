#include <iostream>
#include <queue>
#include <cstring>
#include <vector>

using namespace std;
// order: W -> N -> E -> S
int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};
bool a[50][50][4];
int g[50][50];
int n, m;

int bfs(int sx, int sy, int numR) {
    int cnt = 0;
    queue<pair<int, int>> q;
    q.push({sx, sy});
    g[sx][sy] = numR;
    while(!q.empty()) {
        cnt++;
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            if(a[x][y][i]) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(g[nx][ny] != 0) continue;
            q.push({nx, ny});
            g[nx][ny] = numR;
        }
    }
    return cnt;
}

int main() {
    // input
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int b;
            cin >> b;
            for(int k = 0; k < 4; k++) {
                if(b & (1 << k)) {
                    a[i][j][k] = true;
                }
            }
        }
    }

    // operation 1, 2
    // 1. 이 성에 있는 방의 개수
    // 2. 가장 넓은 방의 넓이
    int numR = 0;
    int maxR1 = 0;
    vector<int> r;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(g[i][j] == 0) {
                numR++;
                int res = bfs(i, j, numR);
                r.push_back(res);
                maxR1 = max(maxR1, res);
            }
        }
    }
    
    // operation 3
    // 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
    int maxR2 = maxR1;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < 4; k++) {
                if(a[i][j][k]) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if(g[i][j] == g[nx][ny]) continue;
                    int res = r[g[i][j] - 1] + r[g[nx][ny] - 1];
                    maxR2 = max(maxR2, res);
                }
            }
        }
    }

    // output
    cout << numR << '\n';
    cout << maxR1 << '\n';
    cout << maxR2 << '\n';
    return 0;
}