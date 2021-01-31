// 인접행렬을 이용한 bfs

#include <iostream>
#include <cstdio>
#include <deque>
#include <algorithm>
#include <cstring>
#include <tuple>

using namespace std;
int g[100][100];
int d[100][100];
int n, m;
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};

void bfs(int sx, int sy) {
    deque<pair<int, int>> q;
    q.push_front(make_pair(sx, sy));
    d[sx][sy] = 0;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop_front();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(d[nx][ny] == -1) {
                    if(g[nx][ny] == 0) {
                        d[nx][ny] = d[x][y];
                        q.push_front(make_pair(nx, ny));
                    }
                    else if(g[nx][ny] == 1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.push_back(make_pair(nx, ny));
                    }
                }
            }
        }
    }
}

int main() {
    scanf("%d %d", &m, &n);
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            scanf("%1d", &g[i][j]);
        }
    }
    memset(d, -1, sizeof(d));
    bfs(0, 0);
    printf("%d\n", d[n-1][m-1]);
    return 0;
}