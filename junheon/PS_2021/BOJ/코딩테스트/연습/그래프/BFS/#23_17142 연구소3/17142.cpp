#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;
int a[50][50];
int d[50][50];
bool c[10];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m;
int ans = -1;

int bfs(vector<pair<int, int>> &v) {
    queue<pair<int, int>> q;
    for(int i = 0; i < v.size(); i++) {
        if(c[i]) {
            int x = v[i].first;
            int y = v[i].second;
            q.push({x, y});
            d[x][y] = 0;
        }
    }
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(a[nx][ny] == 1) continue;
            if(d[nx][ny] != -1) continue;
            d[nx][ny] = d[x][y] + 1;
            q.push({nx, ny});
        }
    }
    int res = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(a[i][j] == 0) {
                if(d[i][j] == -1) return -1;
                res = max(res, d[i][j]);
            }
        }
    }
    return res;
}

// m개의 바이러스를 두는 경우
// Number of cases where m viruses are placed
void go(vector<pair<int, int>> &v, int index, int selected) {
    if(selected == m) {
        memset(d, -1, sizeof(d));
        int res = bfs(v);
        if(res != -1) {
            if(ans == -1 || ans > res) {
                ans = res;
            }
        }
        return;
    }
    if(index >= v.size()) return;
    c[index] = true;
    go(v, index + 1, selected + 1);
    c[index] = false;
    go(v, index + 1, selected);
}

int main() {
    // input
    cin >> n >> m;
    vector<pair<int, int>> v;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> a[i][j];
            if(a[i][j] == 2) {
                v.push_back({i, j});
            }
        }
    }    

    go(v, 0, 0);

    // output
    cout << ans << '\n';
    return 0;
}