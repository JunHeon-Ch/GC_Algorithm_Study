// 연결 리스트를 이용한 bfs

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
vector<int> g[1001];
bool check[1001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    for(int i = 1; i <= n; i++) {
        sort(g[i].begin(), g[i].end());
    }

    int cnt = 0;
    queue<int> q;
    for(int i = 1; i <= n; i++) {
        if(!check[i]) {
            cnt++;
            check[i] = true;
            q.push(i);
            while(!q.empty()) {
                int x = q.front();
                q.pop();
                for(int i = 0; i < g[x].size(); i++) {
                    int y = g[x][i];
                    if(!check[y]) {
                        check[y] = true;
                        q.push(y);
                    }
                }
            }
        }
    }
    cout << cnt << '\n';

    return 0;
}