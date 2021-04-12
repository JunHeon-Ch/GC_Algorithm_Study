// 인접 행렬을 이용한 bfs

#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;
int g[50][50];
bool island[50][50]; 
int dx[8] = {0, 0, 1, -1, -1, -1, 1, 1};
int dy[8] = {1, -1, 0, 0, -1, 1, -1, 1};
int w, h;

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    island[x][y] = true;
    while(!q.empty()) {
        int x1 = q.front().first;
        int y1 = q.front().second;
        q.pop();
        for(int i = 0; i < 8; i++) {
            int nx = x1 + dx[i];
            int ny = y1 + dy[i];
            if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if(!island[nx][ny] && g[nx][ny]) {
                    q.push(make_pair(nx, ny));
                    island[nx][ny] = true;
                } 
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    while(true) {
        cin >> w >> h;
        if(w == 0 && h == 0) return 0;

        memset(island, false, sizeof(island));

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                cin >> g[i][j];
            }
        }

        int cnt = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(g[i][j] && !island[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}