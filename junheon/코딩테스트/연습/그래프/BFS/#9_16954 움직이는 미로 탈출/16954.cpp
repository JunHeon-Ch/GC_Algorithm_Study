#include <iostream>
#include <queue>

using namespace std;
char a[8][8];
bool c[8][8];
int dx[] = {0, 0, -1, -1, -1, -1, 1, 1};
int dy[] = {-1, 1, 0, 0, -1, 1, -1, 1};

bool bfs() {
    queue<pair<int, int>> q;
    q.push(make_pair(7, 0));
    c[7][0] = true;
    while(!q.empty()) {
        int size = q.size();
        // 캐릭터 이동
        while(size--) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            if(x == 0 && y == 7) return true;
            // 움직이지 않기
            if(a[x - 1][y] != '#') {                
                q.push(make_pair(x, y));
            }
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                // 이동할 위치의 위에 벽이 있으면 안됨
                if(a[nx - 1][ny] == '#') continue;
                if(a[nx][ny] == '.') {
                    if(c[nx][ny]) continue;
                    c[nx][ny] = true;
                    q.push(make_pair(nx, ny));
                }
            }
        }
        // 벽 이동
        for(int i = 7; i >= 0; i--) {
            for(int j = 0; j < 8; j++) {
                if(i == 0) a[i][j] = '.';
                else a[i][j] = a[i - 1][j];
            }
        }
    }
    return false;
}

int main() {
    // input
    for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
            cin >> a[i][j];
        }
    }

    bool ans = bfs();
    
    // output
    cout << ans ? 1 : 0 << '\n';
    return 0;
}