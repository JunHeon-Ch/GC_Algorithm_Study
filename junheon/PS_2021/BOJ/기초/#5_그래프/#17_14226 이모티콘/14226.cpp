#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
#include <tuple>

using namespace std;
int d[1001][1001];

int main() {
    int k;
    cin >> k;
    memset(d, -1, sizeof(d));
    queue<pair<int, int>> q;
    q.push(make_pair(1, 0));
    d[1][0] = 0;
    while(!q.empty()) {
        int s, c;
        tie(s, c) = q.front();
        q.pop();
        // 화면의 이모티콘을 클립보드에 복사
        if(d[s][s] == -1) {
            d[s][s] = d[s][c] + 1;
            q.push(make_pair(s, s));
        }
        // 클립보드의 이모티콘을 화면에 붙여넣기
        if(s + c <= k && d[s + c][c] == -1) {
            d[s + c][c] = d[s][c] + 1;
            q.push(make_pair(s + c, c));
        }
        // 화면의 이모티콘 하나 지우기
        if(s - 1 >= 0 && d[s - 1][c] == -1) {
            d[s - 1][c] = d[s][c] + 1;
            q.push(make_pair(s - 1, c));
        }
    }

    int ans = -1;
    for(int i = 0; i <= k; i++) {
        if(d[k][i] != -1) {
            if(ans == -1 || ans > d[k][i]) {
                ans = d[k][i];
            }
        }
    }
    cout << ans << '\n';
    return 0;
}