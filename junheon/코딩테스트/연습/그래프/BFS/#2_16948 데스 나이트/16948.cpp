#include <iostream>
#include <queue>
#include <cstring>

using namespace std;
int c[200][200];
int dx[] = {-2, -2, 0, 0, 2, 2};
int dy[] = {-1, 1, -2, 2, -1, 1};
int n;
int r1, c1, r2, c2;

void bfs() {
    queue<pair<int, int>> q;
    q.push(make_pair(r1, c1));
    c[r1][c1] = 0;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(c[nx][ny] == -1) {
                    c[nx][ny] = c[x][y] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    cin >> n;
    cin >> r1 >> c1 >> r2 >> c2;
    memset(c, -1, sizeof(c));

    bfs();

    // output
    cout << c[r2][c2] << '\n';
    return 0;
}