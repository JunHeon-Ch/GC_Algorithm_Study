#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};

vector<vector<int>> bfs(vector<vector<char>> &a , int sx, int sy) {
    int h = a.size();
    int w = a[0].size();
    vector<vector<int>> d(h, vector<int>(w, -1));
    queue<pair<int, int>> q;
    q.push({sx, sy});
    d[sx][sy] = 0;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if(a[nx][ny] == 'x' || d[nx][ny] != -1) continue;
            d[nx][ny] = d[x][y] + 1;
            q.push({nx, ny});
        }
    }
    return d;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while(true) {
        // input
        int w, h;
        cin >> w >> h;
        if(w == 0 && h == 0) break;
        // a -> graph / b -> start point
        vector<vector<char>> a(h, vector<char>(w));
        vector<pair<int, int>> b(1);
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                cin >> a[i][j];
                if(a[i][j] == 'o') {
                    b[0] = {i, j};
                }
                else if(a[i][j] == '*') {
                    b.push_back({i, j});
                }
            }
        }

        // operation
        bool flag = false;
        // 한 점에서 다른 한 점까지의 최소값을 d에 저장
        // store the minimum value in 'd' from one point to the other
        int n = b.size();
        vector<vector<int>> d(n, vector<int>(n));
        for(int i = 0; i < n; i++) {
            auto dist = bfs(a, b[i].first, b[i].second);
            for(int j = 0; j < n; j++) {
                d[i][j] = dist[b[j].first][b[j].second];
                if(d[i][j] == -1) flag = true;
            }
        }
        if(flag) {
            cout << -1 << '\n';
            continue;
        }

        // 'o'에서 시작해서 '*'까지 가능한 모든 순열 중에 최소값을 찾음
        // found minimum of all possible permutations from 'o' to '*'
        vector<int> p(n - 1);
        for(int i = 0; i < n - 1; i++) {
            p[i] = i + 1;
        }
        int ans = -1;
        do {
            int res = d[0][p[0]];
            for(int i = 0; i < n - 2; i++) {
                res += d[p[i]][p[i + 1]];
            }
            if(ans == -1 || ans > res) {
                ans = res;
            }
        } while(next_permutation(p.begin(), p.end()));

        // output
        cout << ans << '\n';
    }

    return 0;
}