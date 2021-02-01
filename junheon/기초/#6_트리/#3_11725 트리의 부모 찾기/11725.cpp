// 인접 리스트를 이용한 dfs

#include <iostream>
#include <vector>

using namespace std;
// g -> 그래프 / p -> 부모 노드 저장 / c -> 방문 여부
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

    // 입력
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

    // 출력
    for(int i = 1; i < n; i++) {
        cout << p[i] << '\n';
    }
    return 0;
}