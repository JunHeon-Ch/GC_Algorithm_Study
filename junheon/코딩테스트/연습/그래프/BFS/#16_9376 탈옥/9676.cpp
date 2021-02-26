#include <iostream>
#include <deque>
#include <cstring>

using namespace std;
struct map {
    int x, y, n;
};
char a[102][102];
int c[102][102][3];
int dx[] = {0, 0, -1, 1};
int dy[] = {-1, 1, 0, 0};
int w, h;
deque<map> q;

void bfs() {
    while(!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int n = q.front().n;
        q.pop_front();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
            if(a[nx][ny] == '*') continue;
            if(c[nx][ny][n] != -1) continue;
            if(a[nx][ny] == '.' || a[nx][ny] == '$') {
                c[nx][ny][n] = c[x][y][n];
                q.push_front({nx, ny, n});
            }
            else if(a[nx][ny] == '#') {
                c[nx][ny][n] = c[x][y][n] + 1;
                q.push_back({nx, ny, n});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // input
    int t;
    cin >> t;
    while(t--) {
        q = deque<map>();
        cin >> h >> w;
        memset(c, -1, sizeof(c));
        int idx = 0;
        for(int i = 0; i < h + 2; i++) {
            for(int j = 0; j < w + 2; j++) {
                if(i == 0 || i == h + 1 || j == 0 || j == w + 1) {
                    a[i][j] = '.';
                }
                else {
                    cin >> a[i][j];
                    // 죄수 위치부터 출발하는 경우
                    // Departure from the position of the prisoner.
                    if(a[i][j] == '$') {
                        q.push_back({i, j, idx});
                        c[i][j][idx] = 0;
                        idx++;
                    }
                }
            }
        }
        // 밖에서 출발하는 경우
        // Departure from outside
        q.push_back({0, 0, idx});
        c[0][0][idx] = 0;
        
        bfs();
        
        // 3가지 경우의 합 중 최소값을 찾는다
        // 만나는 지점이 문일 경우 -2
        // Find the minimum of the three cases.
        // If the contact point is a door, result-2
        int ans = -1;
        for(int i = 1; i <= h; i++) {
            for(int j = 1; j <= w; j++) {
                if(a[i][j] == '*') continue;
                int res = 0;
                for(int k = 0; k < 3; k++) {
                    res += c[i][j][k];
                }
                if(res < 0) continue;
                if(a[i][j] == '#') {
                    res -= 2;
                }
                if(ans == -1 || ans > res) {
                    ans = res;
                }
            }
        }

        // output
        cout << ans << '\n'; 
    }
    return 0;
}