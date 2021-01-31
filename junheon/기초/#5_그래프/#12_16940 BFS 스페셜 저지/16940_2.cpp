// 인접 리스트를 이용한 bfs

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
// g -> 그래프 / c -> 방문 여부
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
    // 입력된 결과 순서 기준으로 인접 리스트 소팅
    // b -> 입력된 순서 / o -> 점들이 나타나는 순서
    vector<int> b(n);
    vector<int> o(n);
    for(int i = 0; i < n; i++) {
        cin >> b[i];
        b[i]--;
        o[b[i]] = i;
    }
    for(int i = 0; i < n; i++) {
        sort(g[i].begin(), g[i].end(), [&](const int u, const int v) {
            return o[u] < o[v];
        });
    }
    
    // bfs를 통해 입력된 결과 순서와 같은지 비교
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