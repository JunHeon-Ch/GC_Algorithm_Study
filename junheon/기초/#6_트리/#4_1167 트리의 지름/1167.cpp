#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;
vector<pair<int, int>> g[100000];
int d[100000];

void bfs(int s) {
    memset(d, -1, sizeof(d));
    queue<int> q;
    q.push(s);
    d[s] = 0;
    while(!q.empty()) {
        int c = q.front();
        q.pop();
        for(int i = 0; i < g[c].size(); i++) {
            int n = g[c][i].first;
            int w = g[c][i].second;
            if(d[n] == -1) {
                d[n] = d[c] + w;
                q.push(n);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // 입력
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        int u, v, w;
        cin >> u; u--;
        while(true) {
            cin >> v; v--;
            if(v == -2) break;
            cin >> w;
            g[u].push_back(make_pair(v, w));
            g[v].push_back(make_pair(u, w));
        }
    }

    // 탐색 2번
    bfs(0);
    int x = 0;
    for(int i = 1; i < n; i++) {
        if(d[x] < d[i]) {
            x = i;
        }
    }
    bfs(x);
    int ans = 0;
    for(int i = 0; i < n; i++) {
        ans = max(ans, d[i]);
    }

    // 출력
    cout << ans << '\n';

    return 0;
}