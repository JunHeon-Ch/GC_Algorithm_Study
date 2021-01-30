// 인접 리스트를 이용한 bfs

#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;
// g -> 그래프 / p -> 현재 위치의 이전 위치 / o -> 입력된 순서
vector<int> g[100000];
int p[100000];
int o[100000];

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
    for(int i = 0; i < n; i++) {
        cin >> o[i];
        o[i]--;
    }

    memset(p, -1, sizeof(p));
    queue<int> q;
    q.push(0);
    p[0] = 0;
    int k = 1;
    for(int i = 0; i < n; i++) {
        if(q.empty()) {
            cout << 0 << '\n';
            return 0;
        }
        int c = q.front();
        q.pop();
        if(c != o[i]) {
            cout << 0 << '\n';
            return 0;
        }
        int cnt = 0;
        for(int n : g[c]) {
            if(p[n] == -1) {
                p[n] = c;
                cnt++;
            }
        }
        for(int j = 0; j < cnt; j++) {
            if(p[o[k + j]] != c || k + j >= n) {
                cout << 0 << '\n';
                return 0;
            }
            q.push(o[k + j]);
        }
        k += cnt;
    }
    cout << 1 << '\n';
}