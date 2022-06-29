// 인접 행렬을 이용한 dfs

#include <iostream>
#include <algorithm>

using namespace std;
int g[50][50];
bool c[50][50];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m;

// 이전 점이 아닌 다음 점이 방문한 적이 있다면 사이클이 있다고 판단
// sx, sy 현재 점 / px, py 이전 점
bool dfs(int sx, int sy, int px, int py) {
    if(c[sx][sy]) {
        return true;
    }
    c[sx][sy] = true;
    for(int i = 0; i < 4; i++) {
        int nx = sx + dx[i];
        int ny = sy + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if(!(nx == px && ny == py) && g[sx][sy] == g[nx][ny]) {
                if(dfs(nx, ny, sx, sy)) return true;
            }
        }
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            char tmp;
            cin >> tmp;
            g[i][j] = tmp - 65;
        }
        cin.ignore();
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(c[i][j] == 0) {
                if(dfs(i, j, -1, -1)) {
                    cout << "Yes" << '\n';
                    return 0;
                }
            }
        }
    }
    cout << "No" << '\n';
    return 0;
}