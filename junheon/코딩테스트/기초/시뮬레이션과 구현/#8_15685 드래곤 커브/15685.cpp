#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;
bool a[101][101];
// E, N, W, S
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};

int main() {
    // input and make dragon curve
    int n;
    scanf("%d", &n);
    vector<pair<int, int>> point;
    int sx, sy, ex, ey, nx, ny;
    for(int i = 0; i < n; i++) {
        int x, y, d, g;
        scanf("%d %d %d %d", &x, &y, &d, &g);
        ex = x + dx[d];
        ey = y + dy[d];
        point.push_back(make_pair(x, y));
        point.push_back(make_pair(ex, ey));
        for(int j = 0; j < g; j++) {
            int size = point.size();
            for(int k = 0; k < size; k++) {
                // rotate 90 => (a, b) -> (-b, a) 
                nx = point[k].first;
                ny = point[k].second;
                nx -= ex; ny -= ey;
                swap(nx, ny);
                nx = -nx;
                nx += ex; ny += ey;
                if(k == 0) {
                    sx = nx; sy = ny;
                }
                point.push_back(make_pair(nx, ny));
            }
            ex = sx; ey = sy;
        }
        // check point
        for(int j = 0; j < point.size(); j++) {
            a[point[j].second][point[j].first] = true;
        }
        point.clear();
    }
    // answer
    int ans = 0;
    for(int i = 0; i < 100; i++) {
        for(int j = 0; j < 100; j++) {
            if(a[i][j] && a[i + 1][j] && a[i][j + 1] && a[i + 1][j + 1]) {
                ans++;
            }
        }
    }
    printf("%d\n", ans);
    return 0;
}