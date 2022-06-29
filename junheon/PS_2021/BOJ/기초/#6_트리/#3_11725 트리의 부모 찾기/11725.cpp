// ���� ����Ʈ�� �̿��� dfs

#include <iostream>
#include <vector>

using namespace std;
// g -> �׷��� / p -> �θ� ��� ���� / c -> �湮 ����
vector<int> g[100000];
int p[100000];
bool c[100000];

void dfs(int parent) {
    c[parent] = true;
    for(int j = 0; j < g[parent].size(); j++) {
        int child = g[parent][j];
        if(!c[child]) {
            p[child] = parent + 1;
            dfs(child);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // �Է�
    int n;
    cin >> n;
    for(int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    dfs(0);

    // ���
    for(int i = 1; i < n; i++) {
        cout << p[i] << '\n';
    }
    return 0;
}