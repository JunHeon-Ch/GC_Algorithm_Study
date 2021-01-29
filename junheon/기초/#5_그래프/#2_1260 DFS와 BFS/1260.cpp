// 연결 리스트를 사용한 dfs, bfs

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
vector<int> g[1001];
bool check[1001];

void dfs(int s) {
    check[s] = true;
    cout << s << ' ';
    for(int i = 0; i < g[s].size(); i++) {
        int v = g[s][i];
        if(check[v] == false) {
            check[v] = true;
            dfs(v);
        }
    }
}

void bfs(int s) {
    queue<int> q;
    check[s] = true;
    q.push(s);
    while(!q.empty()) {
        int x = q.front();
        q.pop();
        cout << x << ' ';
        for(int i = 0; i < g[x].size(); i++) {
            int y = g[x][i];
            if(check[y] == false) {
                check[y] = true;
                q.push(y);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int v, e, s;
    cin >> v >> e >> s;
    for(int i = 0; i < e; i++) {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    for(int i = 1; i <= v; i++) {
        sort(g[i].begin(), g[i].end());
    }

    dfs(s);
    cout << '\n';
    fill_n(check, v + 1, false);
    bfs(s);

    return 0;
}