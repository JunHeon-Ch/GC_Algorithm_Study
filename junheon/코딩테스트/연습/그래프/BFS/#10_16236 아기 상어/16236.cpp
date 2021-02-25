#include <iostream>
#include <queue>
#include <cstring>
#include <vector>

using namespace std;
int a[20][20];
int c[20][20];
int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};
int n;
int ans = 0;

void bfs(int sx, int sy) {
    int size = 2;
    int cnt = 0;
    while(true) {
        memset(c, -1, sizeof(c));
        queue<pair<int, int>> q;
        vector<pair<int, int>> v;
        c[sx][sy] = 0;
        a[sx][sy] = 0;
        q.push(make_pair(sx, sy));
        while(!q.empty()) {
            int q_size = q.size();
            while(q_size--) {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(c[nx][ny] != -1) continue;
                    // 상어보다 물고기가 더 큼 -> 못 지나감
                    // Bigger fish than sharks -> Can't pass.
                    if(a[nx][ny] > size) continue;
                    // 빈칸 or 물고기랑 상어랑 같음 -> 이동
                    // Same as blank or fish and shark -> move
                    if(a[nx][ny] == 0 || a[nx][ny] == size) {
                        c[nx][ny] = c[x][y] + 1;
                        q.push(make_pair(nx, ny));
                    }
                    // 물고기보다 상어가 더 큼 -> 먹음
                    // Sharks bigger than fish -> eat
                    else {
                        c[nx][ny] = c[x][y] + 1;
                        v.push_back(make_pair(nx, ny));
                    }
                }
            }
            if(v.size() != 0) {
                // 거리가 가장 짧은 물고기 중 위+왼에 있는 물고기 찾기
                // Find the fish on the top + left of the shortest distance
                sx = v[0].first;
                sy = v[0].second;
                for(int i = 1; i < v.size(); i++) {
                    if(v[i].first < sx) {
                        sx = v[i].first;
                        sy = v[i].second;
                    }
                    else if(v[i].first == sx && v[i].second < sy) {
                        sy = v[i].second;
                    }
                }
                // 물고기 먹음
                // eat fish
                cnt++;
                if(cnt == size) {
                    size++;
                    cnt = 0;
                }
                ans += c[sx][sy];
                break;
            }
        }
        if(v.size() == 0) return;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    cin >> n;
    int x, y;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
            if(a[i][j] == 9) {
                x = i, y = j;
            }
        }
    }

    bfs(x, y);

    // output
    cout << ans << '\n';
    return 0;
}