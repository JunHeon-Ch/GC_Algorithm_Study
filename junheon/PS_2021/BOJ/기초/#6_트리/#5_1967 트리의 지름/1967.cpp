#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
// g -> �׷��� / c -> �湮 ����
vector<pair<int, int>> g[10000];
bool c[10000];

// first: ����, second: �ִ� ����
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
    // ���� ��� ���� �ִ� ���� ã��
    int height = 0;
    sort(h.begin(), h.end());
    reverse(h.begin(), h.end());
    // ���� ��带 ����ϴ� ��츦 ���� �ִ� ���� ã��
    if(h.size() >= 1) {
        height = h[0];
        ans = max(ans, height);
    }
    // ���� ��带 ������� �ʴ� ��� �� �ִ� ���� ã��
    if(h.size() >= 2) {
        ans = max(ans, h[0] + h[1]);
    }

    return make_pair(ans, height);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // �Է�
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
    
    // ���
    cout << ans.first << '\n';
    
    return 0;
}