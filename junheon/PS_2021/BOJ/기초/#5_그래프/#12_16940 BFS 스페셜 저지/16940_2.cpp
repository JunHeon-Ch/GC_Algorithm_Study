// ���� ����Ʈ�� �̿��� bfs

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
// g -> �׷��� / c -> �湮 ����
vector<int> g[100000];
bool c[100000];

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
    
    // bfs�� ���� �Էµ� ��� ������ ������ ��
    vector<int> ans;
    queue<int> q;
    q.push(0);
    c[0] = true;
    while(!q.empty()) {
        int s = q.front();
        ans.push_back(s);
        q.pop();
        for(int n : g[s]) {
            if(!c[n]) {
                q.push(n);
                c[n] = true;
            }
        }
    }
    if(ans == b) {
        cout << 1 << '\n';
    }
    else {
        cout << 0 << '\n';
    }
}