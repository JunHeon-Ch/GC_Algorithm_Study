#include <cstdio>
#include <queue>
#include <cstring>

using namespace std;
// a -> map / g -> 0's group
// element_cnt -> To check how many zeros are in a group
int a[1000][1000];
int g[1000][1000];
int element_cnt[1000000];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int n, m;

void bfs(int x, int y, int num) {
    queue<pair<int, int>> q;
    int cnt = 1;
    q.push(make_pair(x, y));
    g[x][y] = num;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(a[nx][ny] == 0 && g[nx][ny] == -1) {
                    g[nx][ny] = g[x][y];
                    q.push(make_pair(nx, ny));
                    cnt++;
                }
            }
        }
    }
    element_cnt[num] = cnt;
}

int main() {
    // input
    scanf("%d %d", &n, &m);
    vector<pair<int, int>> one;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            scanf("%1d", &a[i][j]);
            if(a[i][j] == 1) {
                one.push_back(make_pair(i, j));
            }
        }
    }

    // grouping
    memset(g, -1, sizeof(g));
    int num = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(a[i][j] == 0 && g[i][j] == -1) {
                bfs(i, j, num);
                num++;
            }
        }
    }

    // check number of spaces that can be moved
    // gc -> To verify that you have checked by group
    for(int i = 0; i < one.size(); i++) {
        vector<bool> gc(num, false);
        int x = one[i].first;
        int y = one[i].second;
        for(int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                int group_num = g[nx][ny];
                if(group_num == -1) continue;
                if(a[nx][ny] == 0 && !gc[group_num]) {
                    a[x][y] += element_cnt[group_num];
                    a[x][y] %= 10;
                    gc[group_num] = true;
                }
            }
        }
    }

    // output
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            printf("%d", a[i][j]);
        }
        printf("\n");
    }
    return 0;
}