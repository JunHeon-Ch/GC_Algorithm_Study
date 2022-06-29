// ���� ����� �̿��� bfs

#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;
// g -> �׷��� / c -> �� �׷� / d -> �ٸ� ������ �Ÿ�
int g[100][100];
int c[100][100];
int d[100][100];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n;

// bfs�� �̿��Ͽ� ���� ������ �׷�����
void bfs_group(int sx, int sy, int cnt) {
    queue<pair<int, int>> q;
    q.push(make_pair(sx, sy));
    c[sx][sy] = cnt;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(c[nx][ny] == 0 && g[nx][ny] == 1) {
                    c[nx][ny] = cnt;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
}

// bfs�� �̿��Ͽ� �� ������ �ٸ� �������� �Ÿ� ���
int bfs_dist(int cnt) {
    int ans = -1;
    for(int k = 1; k < cnt; k++) {
        memset(d, -1, sizeof(d));
        queue<pair<int, int>> q;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(c[i][j] == k) {
                    q.push(make_pair(i, j));
                    d[i][j] = 0;
                }
            }
        }
        while(!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(d[nx][ny] == -1) {
                        // �ٴٸ�, �Ÿ� �߰�
                        if(c[nx][ny] == 0) {
                            d[nx][ny] = d[x][y] + 1;
                            q.push(make_pair(nx, ny));
                        }
                        // ���� ���� �ƴ� �ٸ� ���̸� �ּҰ� ���
                        else {
                            if(c[nx][ny] != k) {
                                if(ans == -1 || ans > d[x][y]) {
                                    ans = d[x][y];
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    return ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> g[i][j];
        }
    }
    // ���� ������ �׷� ����
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(c[i][j] == 0 && g[i][j] == 1) {
                cnt++;
                bfs_group(i, j, cnt);
            }
        }
    }
    // �ٸ� �������� �Ÿ� ���
    cout << bfs_dist(cnt) << '\n';
    return 0;
}