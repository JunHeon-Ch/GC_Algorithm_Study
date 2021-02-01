#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
// g -> 그래프 / c -> 방문 여부
vector<pair<int, int>> g[10000];
bool c[10000];

// first: 지름, second: 최대 길이
pair<int, int> dfs(int s) {
    c[s] = true;
    vector<int> h;
    int ans = 0;
    for(int i = 0; i < g[s].size(); i++) {
        int n = g[s][i].first;
        int w = g[s][i].second;
        if(!c[n]) {
            pair<int, int> p = dfs(n);
            ans = max(ans, p.first);
            h.push_back(p.second + w);
        }
    }
    // 현재 노드 기준 최대 지름 찾기
    int height = 0;
    sort(h.begin(), h.end());
    reverse(h.begin(), h.end());
    // 현재 노드를 통과하는 경우를 위해 최대 지름 찾기
    if(h.size() >= 1) {
        height = h[0];
        ans = max(ans, height);
    }
    // 현재 노드를 통과하지 않는 경우 중 최대 지름 찾기
    if(h.size() >= 2) {
        ans = max(ans, h[0] + h[1]);
    }
    return make_pair(ans, height);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // 입력
    int n;
    cin >> n;
    for(int i = 0; i < n - 1; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        u--; v--;
        g[u].push_back(make_pair(v, w));
        g[v].push_back(make_pair(u, w));
    }

    // postorder(dfs)
    pair<int, int> ans = dfs(0);
    
    // 출력
    cout << ans.first << '\n';
    return 0;
}