// ���� ����Ʈ�� �̿��� dfs

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
// g -> �׷��� / c -> �湮�ߴ��� üũ / ans -> �湮 ���� ����
vector<int> g[100000];
bool c[100000];
int n;
vector<int> ans;

// dfs�� ���� �Էµ� ��� ������ ������ ��
void dfs(int s) {
    if(c[s]) {
        return;
    }
    c[s] = true;
    ans.push_back(s);
    for(int n : g[s]) {
        if(!c[n]) {
            dfs(n); 
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for(int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    // �Էµ� ��� ���� �������� ���� ����Ʈ ����
    // b -> �Էµ� ���� / o -> ������ ��Ÿ���� ����
    vector<int> b(n);
    vector<int> o(n);
    for(int i = 0; i < n; i++) {
        cin >> b[i];
        b[i]--;
        o[b[i]] = i;
    }
    for(int i = 0; i < n; i++) {
        sort(g[i].begin(), g[i].end(), [&](int u, int v) {
            return o[u] < o[v];
        });
    }

    dfs(0);
    if(b == ans) {
        cout << 1 << '\n';
    }
    else {
        cout << 0 << '\n';
    }

    return 0;
}