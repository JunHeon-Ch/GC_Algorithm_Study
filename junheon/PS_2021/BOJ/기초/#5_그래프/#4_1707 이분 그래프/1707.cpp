// ���� ����Ʈ�� �̿��� dfs

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int check[20001];
vector<int> g[20001];

// dfs�� �̿��Ͽ� �� �������� ���������� ������ ã�� �ٸ� �׷����� �ִ´�
// check[v] == 0 -> v ������ �湮�� ���� ����
void dfs(int s, int group) {
    check[s] = group;
    for(int i = 0; i < g[s].size(); i++) {
        int x = g[s][i];
        if(check[x] == 0) {
            dfs(x, 3 - group);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while(t--) {
        int n, m;
        cin >> n >> m;
        for(int i = 1; i <= n; i++) {
            check[i] = 0;
            g[i].clear();
        }
        for(int i = 0; i < m; i++) {
            int u, v;
            cin >> u >> v;
            g[u].push_back(v);
            g[v].push_back(u);
        }

        for(int i = 1; i <= n; i++) {
            if(check[i] == 0) {
                dfs(i, 1);
            }
        }

        bool flag = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < g[i].size(); j++) {
                int k = g[i][j];
                if(check[i] == check[k]) {
                    flag = false;
                }
            }
        }

        cout << (flag ? "YES" : "NO") << '\n';
    }

    return 0;
}