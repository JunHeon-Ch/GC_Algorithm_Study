// 인접 리스트를 이용한 bfs

#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;
// g -> 그래프 / check -> 몇번째 방문했는지
vector<int> g[100000];
int p[100000];
int o[100000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    for(int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    for(int i = 0; i < n; i++) {
        cin >> o[i];
        o[i]--;
    }

    memset(p, -1, sizeof(p));
    queue<int> q;
    q.push(0);
    p[0] = 0;
    int k = 1;
    for(int i = 0; i < n; i++) {
        int c = q.front();
        q.pop();
        int cnt = 0;
        for(int n : g[c]) {
            if(p[n] == -1) {
                p[n] = c;
                cnt++;
            }
        }
        for(int j = 0; j < cnt; j++) {
            if(p[o[k + j]] != c) {
                cout << 0 << '\n';
                return 0;
            }
            q.push(o[k + j]);
        }
        k += cnt;
    }
    cout << 1 << '\n';
}