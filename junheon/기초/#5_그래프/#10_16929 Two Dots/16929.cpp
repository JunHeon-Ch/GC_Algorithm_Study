// 인접 행렬을 이용한 dfs

#include <iostream>
#include <algorithm>

using namespace std;
int g[50][50];
int c[50][50];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m;

// 현재 점이 방문한 적 있고, 현재 깊이와 차이가 4이상이면 4이상의 사이클이 있다고 판단
bool dfs(int sx, int sy, int cnt) {
    if(c[sx][sy] > 0) {
        if(cnt - c[sx][sy] >= 4)
            return true;
        else
            return false;
    }
    c[sx][sy] = cnt;
    for(int i = 0; i < 4; i++) {
        int nx = sx + dx[i];
        int ny = sy + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if(g[sx][sy] == g[nx][ny]) {
                if(dfs(nx, ny, cnt + 1)) return true;
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
                if(dfs(i, j, 1)) {
                    cout << "Yes" << '\n';
                    return 0;
                }
            }
        }
    }
    cout << "No" << '\n';
    return 0;
}