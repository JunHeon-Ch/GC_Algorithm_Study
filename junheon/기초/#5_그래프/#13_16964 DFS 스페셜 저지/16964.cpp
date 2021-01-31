// 인접 리스트를 이용한 dfs

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
// g -> 그래프 / c -> 방문했는지 체크 / ans -> 방문 순서 저장
vector<int> g[100000];
bool c[100000];
int n;
vector<int> ans;

// dfs를 통해 입력된 결과 순서와 같은지 비교
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
    // 입력된 결과 순서 기준으로 인접 리스트 소팅
    vector<int> b(n);
    vector<int> o(n);
    for(int i = 0; i < n; i++) {
        cin >> b[i];
        b[i]--;
        o[b[i]] = i;
    }
    for(int i = 0; i < n; i++) {
        sort(g[i].begin(), g[i].end(), [&](const int &u, const int &v) {
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